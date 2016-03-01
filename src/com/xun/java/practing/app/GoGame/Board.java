package com.xun.java.practing.app.GoGame;

/**
 * Created by cuixun on 4/5/14.
 */


import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Board extends Panel {
    public static final int _rectLen = 22, _rectNum = 19;
    protected Vector stones;

    protected int num;
    protected int currentTurn;
    protected int rectNum, rectLen;
    protected int stoneLen;
    protected Stone[][] map;
    protected Image offscreen;
    protected Graphics offg;
    protected int size;

    protected int top, left;
    protected Point mouseLoc;
    protected ControlPanel controlPanel;

    public int getWidth() {
        return size + controlPanel.getWidth() + 35;
    }

    public int getHeight() {
        return size;
    }


    public Board() {
        top = left = 20;
        rectNum = _rectNum;
        rectLen = _rectLen;
        stoneLen = rectLen * 9 / 10;
        size = 2 * left + rectNum * rectLen;
        addMouseListener(new ML());
        addMouseMotionListener(new MML());
        setLayout(new BorderLayout());
        controlPanel = new ControlPanel();
        setSize(getWidth(), size);
        add(controlPanel, "East");
        setSize(getWidth(), size);
        add(controlPanel, "East");

        start();
    }

    public void addNotify() {
        super.addNotify();
        offscreen = createImage(size, size);
        offg = offscreen.getGraphics();
    }

    /**
     * Paint
     *
     * @param g
     */
    public void paint(Graphics g) {
        offg.setColor(new Color(180, 150, 100));
        offg.fillRect(0, 0, size, size);
        /**Draw board
         */
        offg.setColor(Color.black);
        for (int i = 0; i < rectNum + 1; i++) {
            int x1 = left + i * rectLen;
            int x2 = x1;
            int y1 = top;
            int y2 = top + rectNum * rectLen;
            offg.drawLine(x1, y1, x2, y2);
            x1 = left;
            x2 = left + (rectNum - 1) * rectLen;
            y1 = top + i * rectLen;
            y2 = y1;
            offg.drawLine(x1, y1, x2, y2);
        }

        for (int i = 0; i < rectNum + 1; i++)
            for (int j = 0; j < rectNum + 1; j++) {
                if (map[i][j] == null)
                    continue;
                offg.setColor(map[i][j].color == Stone._black ? Color.black : Color.white);
                offg.fillOval(left + i * rectLen - stoneLen / 2, top + j * rectLen - stoneLen / 2,
                        stoneLen, stoneLen);
            }

        if (mouseLoc != null) {
            offg.setColor(currentTurn == Stone._black ? Color.gray :
                    new Color(200, 200, 250));
            offg.fillOval(left + mouseLoc.x * rectLen - stoneLen / 2,
                    top + mouseLoc.y * rectLen - stoneLen / 2,
                    stoneLen, stoneLen);
        }

        g.drawImage(offscreen, 0, 0, this);
    }

    public void update(Graphics g) {
        paint(g);
    }

    class ML extends MouseAdapter {
        public void mousePressed(MouseEvent evt) {
            int xoff = left / 2;
            int yoff = top / 2;
            int x = (evt.getX() - xoff) / rectLen;
            int y = (evt.getY() - yoff) / rectLen;
            if (x < 0 || x > rectNum || y < 0 || y > rectNum)
                return;
            if (map[x][y] != null)
                return;
            /**Clear stone of previous location
             */
            if (num < stones.size()) {
                int size = stones.size();
                for (int i = size - 1; i >= num; i--)
                    stones.removeElementAt(i);
            }
            Stone stone = new Stone(x, y, currentTurn);
            map[x][y] = stone;
            stones.addElement(stone);
            num++;
            if (currentTurn == Stone._black) {
                currentTurn = Stone._white;
            } else {
                currentTurn = Stone._black;
            }

            grape(x, y);

            /**
             * Valid check
             */
            if (allDead(stone).size() != 0) {
                map[x][y] = null;
                repaint();
                controlPanel.setMsg("Invalid move");
                stones.removeElement(stone);
                num--;
                if (currentTurn == Stone._black)
                    currentTurn = Stone._white;
                else
                    currentTurn = Stone._black;
                return;
            }
            mouseLoc = null;
            controlPanel.setLabel();
        }

        public void mouseExited(MouseEvent evt) {
            mouseLoc = null;
            repaint();
        }
    }

    private class MML extends MouseMotionAdapter {

        public void mouseMoved(MouseEvent evt) {
            int xoff = left / 2;
            int yoff = top / 2;
            int x = (evt.getX() - xoff) / rectLen;
            int y = (evt.getY() - yoff) / rectLen;
            if (x < 0 || x > rectNum || y < 0 || y > rectNum)
                return;
            if (map[x][y] != null)
                return;
            mouseLoc = new Point(x, y);
            repaint();
        }
    }

    /**
     * Check valid of Grape
     */
    public static int[] xdir = {0, 0, 1, -1};
    public static int[] ydir = {1, -1, 0, 0};

    public void grape(int x, int y) {
        Stone stone;
        if ((stone = map[x][y]) == null)
            return;
        int color = stone.color;

        Vector v = around(stone);
        for (int l = 0; l < v.size(); l++) {
            Stone q = (Stone) (v.elementAt(l));
            if (q.color == color)
                continue;

            /**
             * Get all the dead
             */
            Vector dead = allDead(q);

            /**
             * Remove all the dead
             */
            removeAll(dead);
/**
 *Save all the dead stones
 */
            if (dead.size() != 0) {
                Object obj = stones.elementAt(num - 1);
                if (obj instanceof Stone) {
                    stone = (Stone) (stones.elementAt(num - 1));
                    dead.addElement(stone);
                } else {
                    Vector vector = (Vector) obj;
                    for (int i = 0; i < vector.size(); i++)
                        dead.addElement(vector.elementAt(i));
                }
                //Updates the vector
                stones.setElementAt(dead, num - 1);
            }
        }
        repaint();
    }

    /**
     * @param stone
     * @return
     */
    public boolean sideByBlank(Stone stone) {
        for (int l = 0; l < xdir.length; l++) {
            int xl = stone.x + xdir[l];
            int yl = stone.y + ydir[l];
            if (xl < 0 || xl > rectNum || yl > rectNum)
                continue;
            if (map[xl][yl] == null)
                return true;
        }
        return false;
    }


    /**
     * Get how many numbers of stones around it
     *
     * @param stone
     * @return
     */
    public Vector around(Stone stone) {
        Vector v = new Vector();
        for (int l = 0; l < xdir.length; l++) {
            int xl = stone.x + xdir[l];
            int yl = stone.y + ydir[l];
            if (xl < 0 || xl > rectNum || yl < 0 || yl > rectNum || map[xl][yl] == null)
                continue;
            v.addElement(map[xl][yl]);
        }
        return v;
    }


    /**
     * Grape all the dead stones,
     * If no, return empty
     *
     * @param q
     * @return
     */
    public Vector allDead(Stone q) {
        Vector v = new Vector();
        v.addElement(q);
        int count = 0;
        while (true) {
            int origsize = v.size();
            for (int i = count; i < origsize; i++) {
                Stone stone = (Stone) (v.elementAt(i));
                if (sideByBlank(stone))
                    return new Vector();
                Vector around = around(stone);
                for (int j = 0; j < around.size(); j++) {
                    Stone a = (Stone) (around.elementAt(j));
                    if (a.color != stone.color)
                        continue;
                    if (v.indexOf(a) < 0)
                        v.addElement(a);
                }
            }
            if (origsize == v.size())
                break;
            else
                count = origsize;
        }
        return v;
    }


    /**
     * Remove stones in the vector
     *
     * @param v
     */
    public void removeAll(Vector v) {
        for (int i = 0; i < v.size(); i++) {
            Stone q = (Stone) (v.elementAt(i));
            map[q.x][q.y] = null;
        }
    }

    /**
     * Regret
     */
    public void back() {
        if (num == 0) {
            controlPanel.setMsg("Not any more");
            return;
        }
        Object obj = stones.elementAt(--num);
        if (obj instanceof Stone) {
            Stone stone = (Stone) obj;
            map[stone.x][stone.y] = null;
            currentTurn = stone.color;
        } else {
            Vector v = (Vector) obj;
            for (int i = 0; i < v.size(); i++) {
                Stone q = (Stone) (v.elementAt(i));
                if (i == v.size() - 1) {
                    map[q.x][q.y] = null;
                    int index = stones.indexOf(v);
                    stones.setElementAt(q, index);
                    currentTurn = q.color;
                } else {
                    map[q.x][q.y] = q;
                }
            }
        }
        controlPanel.setLabel();
        repaint();
    }

    /**
     * Cancel regret
     */
    public void forward() {
        if (num == stones.size()) {
            controlPanel.setMsg("不能前进");
            return;
        }
        Object obj = stones.elementAt(num++);
        Stone stone;
        if (obj instanceof Stone) {
            stone = (Stone) (obj);
            map[stone.x][stone.y] = stone;
        } else {
            Vector v = (Vector) obj;
            stone = (Stone) (v.elementAt(v.size() - 1));
            map[stone.x][stone.y] = stone;
        }
        if (stone.color == Stone._black)
            currentTurn = Stone._white;
        else
            currentTurn = Stone._black;
        grape(stone.x, stone.y);
        controlPanel.setLabel();
        repaint();
    }

    /**
     * Restart
     */
    public void start() {
        stones = new Vector();
        num = 0;
        map = new Stone[rectNum + 1][rectNum + 1];
        currentTurn = Stone._black;
        controlPanel.setLabel();
        repaint();
    }

    /**
     * Control Panel
     */
    class ControlPanel extends Panel {
        protected Label lblTurn = new Label("", Label.CENTER);
        protected Label lblNum = new Label("", Label.CENTER);
        protected Label lblMsg = new Label("", Label.CENTER);
        protected Choice choice = new Choice();
        protected Button back = new Button("<< Regret");
        protected Button forward = new Button("Forward>>");
        protected Button start = new Button("Restart");

        public int getWidth() {
            return 60;
        }

        public int getHeight() {
            return size;
        }

        /**
         * Choice the board size
         */
        public ControlPanel() {
            setSize(this.getWidth(), this.getHeight());
            setLayout(new GridLayout(12, 1, 0, 10));
            setLabel();
            choice.add("19 X 19");
            choice.add("15 X 15");
            choice.add("13 X 13");
            choice.add("11 X 11");
            choice.add("7 X 7");
            choice.addItemListener(new IL());
            add(lblTurn);
            add(lblNum);
            add(start);
            add(choice);
            add(lblMsg);
            add(back);
            add(forward);
            back.addActionListener(new AL());
            forward.addActionListener(new AL());
            start.addActionListener(new AL());
            setBackground(new Color(120, 120, 200));
        }

        public Insets getInsets() {
            return new Insets(5, 5, 5, 5);
        }

        private class AL implements ActionListener {

            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource() == back)
                    Board.this.back();
                else if (evt.getSource() == forward)
                    Board.this.forward();
                else if (evt.getSource() == start)
                    Board.this.start();
            }
        }

        private class IL implements ItemListener {

            public void itemStateChanged(ItemEvent evt) {
                String s = (String) (evt.getItem());
                int rects = Integer.parseInt(s.substring(0, 2).trim());
                if (rects != Board.this.rectNum) {
                    Board.this.rectLen = (_rectLen * _rectNum) / rects;
                    Board.this.stoneLen = rectLen * 9 / 10;
                    Board.this.rectNum = rects;
                    Board.this.start();
                }
            }
        }

        public void setLabel() {
            lblTurn.setText(Board.this.currentTurn == Stone._black ? "Black" : "Withe");
            lblTurn.setForeground(Board.this.currentTurn == Stone._black ? Color.black :
                    Color.white);
            lblNum.setText((Board.this.num + 1) + " steps");
            lblNum.setForeground(Board.this.currentTurn == Stone._black ? Color.black :
                    Color.white);
            lblMsg.setText("");
        }

        public void setMsg(String msg) {
            lblMsg.setText(msg);
        }
    }
}
