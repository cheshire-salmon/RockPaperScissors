package ru.tutorial.other;


import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Main extends JFrame implements MouseInputListener {
    static int yourWins = 0;
    static int computersWins = 0;

    static int mouseX = 0;
    static int mouseY = 0;
    //кнопка камня
    static int buttonX = 50;
    static int buttonY = 100;
    static int buttonW = 100;
    static int buttonH = 50;
    //кнопка бумаги
    static int buttonX1 = 50;
    static int buttonY1 = 200;
    static int buttonW1 = 100;
    static int buttonH1 = 50;
    //кнопка ножниц
    static int buttonX2 = 50;
    static int buttonY2 = 300;
    static int buttonW2 = 100;
    static int buttonH2 = 50;

    //кнопка ящерицы
    static int buttonX3 = 50;
    static int buttonY3 = 400;
    static int buttonW3 = 100;
    static int buttonH3 = 50;

    //кнопка спока
    static int buttonX4 = 50;
    static int buttonY4 = 500;
    static int buttonW4 = 100;
    static int buttonH4 = 50;
    static boolean buttonActive = true;
    static boolean buttonActive1 = true;
    static boolean buttonActive2 = true;
    static boolean buttonActive3 = true;
    static boolean buttonActive4 = true;
    //-----------_opponent_opponent_opponent_opponent--------------//
    static boolean buttonActive_opponent = false;
    static boolean buttonActive_opponent1 = false;
    static boolean buttonActive_opponent2 = false;
    static boolean buttonActive_opponent3 = false;
    static boolean buttonActive_opponent4 = false;
    //----------надпись проигрыша и выигрыша----------//
    static boolean buttonActive_lose = false;
    static boolean buttonActive_win = false;
    static boolean buttonActive_draw = false;
    static boolean buttonActive_score = true;
    public static void draw(Graphics2D g) {
        //камушек
        if (buttonActive) {
            g.setColor(new Color(0, 0, 255, 128));
            g.fillRect(buttonX, buttonY, buttonW, buttonH);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(3));
            g.drawRect(buttonX, buttonY, buttonW, buttonH);
            g.setColor(Color.BLACK);
            g.setFont(new Font("", Font.BOLD, buttonH / 4));
            g.drawString("камунэШЕК", buttonX + buttonW / 5, buttonY + buttonH / 2);
        }

        //------------------------------------------------------------//
        //бумажка
        if (buttonActive1) {
            g.setColor(new Color(255, 0, 0, 128));
            g.fillRect(buttonX1, buttonY1, buttonW1, buttonH1);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(3));
            g.drawRect(buttonX1, buttonY1, buttonW1, buttonH1);
            g.setColor(Color.BLACK);
            g.setFont(new Font("", Font.BOLD, buttonH1 / 4));
            g.drawString("бумагЭ", buttonX1 + buttonW1 / 5, buttonY1 + buttonH1 / 2);
        }
        //------------------------------------------------------------//
        //бездонные-ножнички
        if (buttonActive2) {
            g.setColor(new Color(0, 255, 0, 100));
            g.fillRect(buttonX2, buttonY2, buttonW2, buttonH2);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(3));
            g.drawRect(buttonX2, buttonY2, buttonW2, buttonH2);
            g.setColor(Color.BLACK);
            g.setFont(new Font("", Font.BOLD, buttonH2 / 4));
            g.drawString("ножницЫ", buttonX2 + buttonW2 / 5, buttonY2 + buttonH2 / 2);
        }
        //------------------------------------------------------------//
        //ящерка
        if (buttonActive3) {
            g.setColor(new Color(0, 255, 255, 100));
            g.fillRect(buttonX3, buttonY3, buttonW3, buttonH3);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(3));
            g.drawRect(buttonX3, buttonY3, buttonW3, buttonH3);
            g.setColor(Color.BLACK);
            g.setFont(new Font("", Font.BOLD, buttonH3 / 4));
            g.drawString("ЯщеридзЭ", buttonX3 + buttonW3 / 5, buttonY3 + buttonH3 / 2);
        }
        //----------надпись проигрыша и выигрыша----------//
        //Спок
        if (buttonActive4) {
            g.setColor(new Color(255, 0, 255, 100));
            g.fillRect(buttonX4, buttonY4, buttonW4, buttonH4);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(3));
            g.drawRect(buttonX4, buttonY4, buttonW4, buttonH4);
            g.setColor(Color.BLACK);
            g.setFont(new Font("", Font.BOLD, buttonH3 / 4));
            g.drawString("Чпоньк", buttonX4 + buttonW4 / 5, buttonY4 + buttonH4 / 2);
        }
       //-----------_opponent_opponent_opponent_opponent--------------//
            if (buttonActive_opponent) {
                g.setColor(new Color(0, 0, 255, 128));
                g.fillRect(buttonX+200, buttonY2, buttonW, buttonH);
                g.setColor(Color.BLACK);
                g.setStroke(new BasicStroke(3));
                g.drawRect(buttonX+200, buttonY2, buttonW, buttonH);
                g.setColor(Color.BLACK);
                g.setFont(new Font("", Font.BOLD, buttonH / 4));
                g.drawString("камунэШЕК_0", buttonX2 + buttonW2 / 5+185, buttonY2 + buttonH2 / 2);
        }
        //-----------_opponent_opponent_opponent_opponent--------------//
        if (buttonActive_opponent1) {
            g.setColor(new Color(255, 0, 0, 128));
            g.fillRect(buttonX + 200, buttonY2, buttonW, buttonH);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(3));
            g.drawRect(buttonX + 200, buttonY2, buttonW, buttonH);
            g.setColor(Color.BLACK);
            g.setFont(new Font("", Font.BOLD, buttonH / 4));
            g.drawString("бумагЭ_0", buttonX2 + buttonW2 / 5+185, buttonY2 + buttonH2 / 2);
        }
            //-----------_opponent_opponent_opponent_opponent--------------//
            if (buttonActive_opponent2) {
                g.setColor(new Color(0, 255, 0, 128));
                g.fillRect(buttonX + 200, buttonY2, buttonW, buttonH);
                g.setColor(Color.BLACK);
                g.setStroke(new BasicStroke(3));
                g.drawRect(buttonX + 200, buttonY2, buttonW, buttonH);
                g.setColor(Color.BLACK);
                g.setFont(new Font("", Font.BOLD, buttonH / 4));
                g.drawString("ножницЫ_0", buttonX2 + buttonW2 / 5+185, buttonY2 + buttonH2 / 2);
            }

        //-----------_opponent_opponent_opponent_opponent--------------//
        if (buttonActive_opponent3) {
            g.setColor(new Color(0, 255, 255, 128));
            g.fillRect(buttonX + 200, buttonY2, buttonW, buttonH);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(3));
            g.drawRect(buttonX + 200, buttonY2, buttonW, buttonH);
            g.setColor(Color.BLACK);
            g.setFont(new Font("", Font.BOLD, buttonH / 4));
            g.drawString("ЯщеридзЭ_0", buttonX2 + buttonW2 / 5+185, buttonY2 + buttonH2 / 2);
        }
        //-----------_opponent_opponent_opponent_opponent--------------//
        if (buttonActive_opponent4) {
            g.setColor(new Color(255, 0, 255, 128));
            g.fillRect(buttonX + 200, buttonY2, buttonW, buttonH);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(3));
            g.drawRect(buttonX + 200, buttonY2, buttonW, buttonH);
            g.setColor(Color.BLACK);
            g.setFont(new Font("", Font.BOLD, buttonH / 4));
            g.drawString("Чпоньк", buttonX2 + buttonW2 / 5 + 185, buttonY2 + buttonH2 / 2);
        }
        //----------надпись проигрыша и выигрыша----------//
        if (buttonActive_lose){
            g.drawString("you_lose", buttonX + buttonW / 5 + 150, buttonY + buttonH / 2);
            buttonActive_score=false;
            buttonActive_score=true;
        }
        if (buttonActive_win){
            g.drawString("you_win", buttonX + buttonW / 5 + 150, buttonY + buttonH / 2);
            buttonActive_score=false;
            buttonActive_score=true;
        }
        if (buttonActive_draw){
            g.drawString("you/computer_draw", buttonX + buttonW / 5 + 150, buttonY + buttonH / 2);
            buttonActive_score=false;
            buttonActive_score=true;
        }
        if(buttonActive_score){
            g.drawString(yourWins+":"+computersWins, buttonX + buttonW / 5 + 150, buttonY + buttonH / 2+50);
        }
        //----------надпись проигрыша и выигрыша----------//
        g.setFont(new Font("", Font.ITALIC, 10));
        g.drawString("Cheshire-Salmon", mouseX, mouseY);

    }

    //кнопка мышти нажата и отпущена
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e);
        if (e.getButton() == MouseEvent.BUTTON2) {//если мы нажали правую кнопку мыши
            try {
                //Перемещаем курсор мыши в случайную часть экрана
                Robot robot = new Robot();
                Random random = new Random();
                robot.mouseMove(random.nextInt(getWidth()), random.nextInt(getHeight()));
            } catch (AWTException ex) {
            }
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
            //если мы нажали левую кнопку мыши, проверяем помали ли мы на кнопку
            if (buttonActive &&
                    e.getX() >= buttonX && e.getX() <= buttonX + buttonW &&
                    e.getY() >= buttonY && e.getY() <= buttonY + buttonH
            ) {
                buttonActive1 = false;
                buttonActive2 = false;
                buttonActive3 = false;
                buttonActive4 = false;
                Random salmon = new Random();
                int randomNum =  salmon.nextInt(5) + 1;
                System.out.println(randomNum);
                if(randomNum==1){
                    buttonActive_opponent=true;
                    buttonActive_opponent1=false;
                    buttonActive_opponent2=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;

                }  else if(randomNum==2){
                    buttonActive_opponent1=true;
                    buttonActive_opponent=false;
                    buttonActive_opponent2=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }else if(randomNum==3){
                    buttonActive_opponent2=true;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                    }else if(randomNum==4){
                    buttonActive_opponent2=false;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=true;
                    buttonActive_opponent4=false;
                }else if(randomNum==5){
                    buttonActive_opponent2=false;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=true;
                }
                if(randomNum==3){
                    buttonActive_win=true;
                    buttonActive_lose=false;
                    buttonActive_draw=false;
                    yourWins=yourWins+1;
                }else if(randomNum==4){
                    buttonActive_win=true;
                    buttonActive_lose=false;
                    buttonActive_draw=false;
                    yourWins=yourWins+1;
                }else if(randomNum==1) {
                    buttonActive_draw=true;
                    buttonActive_lose=false;
                    buttonActive_win=false;
                }else {
                    buttonActive_lose=true;
                    buttonActive_win=false;
                    buttonActive_draw=false;
                    computersWins=computersWins+1;
                }
            }
        }
        //------------------------------------------------------------//
        if (e.getButton() == MouseEvent.BUTTON2) {//если мы нажали правую кнопку мыши
            try {
                //Перемещаем курсор мыши в случайную часть экрана
                Robot robot = new Robot();
                Random random = new Random();
                robot.mouseMove(random.nextInt(getWidth()), random.nextInt(getHeight()));
            } catch (AWTException ex) {
            }
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
            //если мы нажали левую кнопку мыши, проверяем помали ли мы на кнопку
            if (buttonActive1 &&
                    e.getX() >= buttonX1 && e.getX() <= buttonX1 + buttonW1 &&
                    e.getY() >= buttonY1 && e.getY() <= buttonY1 + buttonH1
            ) {
                buttonActive = false;
                buttonActive2 = false;
                buttonActive3 = false;
                buttonActive4 = false;
                Random salmon = new Random();
                int randomNum =  salmon.nextInt(3) + 1;
                System.out.println(randomNum);
                if(randomNum==1){
                    buttonActive_opponent=true;
                    buttonActive_opponent1=false;
                    buttonActive_opponent2=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }  else if(randomNum==2){
                    buttonActive_opponent1=true;
                    buttonActive_opponent=false;
                    buttonActive_opponent2=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }else if(randomNum==3){
                    buttonActive_opponent2=true;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }else if(randomNum==4){
                    buttonActive_opponent2=false;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=true;
                    buttonActive_opponent4=false;
                }else if(randomNum==5){
                    buttonActive_opponent2=false;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=true;
                }
                if(randomNum==1){
                    buttonActive_win=true;
                    buttonActive_lose=false;
                    buttonActive_draw=false;
                    yourWins=yourWins+1;
                }else if(randomNum==5){
                    buttonActive_win=true;
                    buttonActive_lose=false;
                    buttonActive_draw=false;
                    yourWins=yourWins+1;
                }else if(randomNum==2) {
                    buttonActive_draw=true;
                    buttonActive_lose=false;
                    buttonActive_win=false;
                }else{
                    buttonActive_lose=true;
                    buttonActive_win=false;
                    buttonActive_draw=false;
                    computersWins=computersWins+1;
                }
            }
        }
        //------------------------------------------------------------//
        if (e.getButton() == MouseEvent.BUTTON2) {//если мы нажали правую кнопку мыши
            try {
                //Перемещаем курсор мыши в случайную часть экрана
                Robot robot = new Robot();
                Random random = new Random();
                robot.mouseMove(random.nextInt(getWidth()), random.nextInt(getHeight()));
            } catch (AWTException ex) {
            }
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
            //если мы нажали левую кнопку мыши, проверяем помали ли мы на кнопку
            if (buttonActive1 &&
                    e.getX() >= buttonX2 && e.getX() <= buttonX2 + buttonW2 &&
                    e.getY() >= buttonY2 && e.getY() <= buttonY2 + buttonH2
            ) {
                buttonActive = false;
                buttonActive1 = false;
                buttonActive3 = false;
                buttonActive4 = false;
                Random salmon = new Random();
                int randomNum =  salmon.nextInt(3) + 1;
                System.out.println(randomNum);
                if(randomNum==1){
                    buttonActive_opponent=true;
                    buttonActive_opponent1=false;
                    buttonActive_opponent2=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }  else if(randomNum==2){
                    buttonActive_opponent1=true;
                    buttonActive_opponent=false;
                    buttonActive_opponent2=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }else if(randomNum==3){
                    buttonActive_opponent2=true;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }else if(randomNum==4){
                    buttonActive_opponent2=false;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=true;
                    buttonActive_opponent4=false;
                }else if(randomNum==5){
                    buttonActive_opponent2=false;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=true;
                }
                if(randomNum==2){
                    buttonActive_win=true;
                    buttonActive_lose=false;
                    buttonActive_draw=false;
                    yourWins=yourWins+1;
                }else if(randomNum==4){
                    buttonActive_win=true;
                    buttonActive_lose=false;
                    buttonActive_draw=false;
                    yourWins=yourWins+1;
                }else if(randomNum==3) {
                    buttonActive_draw=true;
                    buttonActive_lose=false;
                    buttonActive_win=false;
                }else{
                    buttonActive_lose=true;
                    buttonActive_win=false;
                    buttonActive_draw=false;
                    computersWins=computersWins+1;
                }
            }
        }
        //------------------------------------------------------------//
        if (e.getButton() == MouseEvent.BUTTON2) {//если мы нажали правую кнопку мыши
            try {
                //Перемещаем курсор мыши в случайную часть экрана
                Robot robot = new Robot();
                Random random = new Random();
                robot.mouseMove(random.nextInt(getWidth()), random.nextInt(getHeight()));
            } catch (AWTException ex) {
            }
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
            //если мы нажали левую кнопку мыши, проверяем помали ли мы на кнопку
            if (buttonActive3 &&
                    e.getX() >= buttonX3 && e.getX() <= buttonX3 + buttonW3 &&
                    e.getY() >= buttonY3 && e.getY() <= buttonY3 + buttonH3
            ) {
                buttonActive = false;
                buttonActive2 = false;
                buttonActive1 = false;
                buttonActive4 = false;
                Random salmon = new Random();
                int randomNum =  salmon.nextInt(3) + 1;
                System.out.println(randomNum);
                if(randomNum==1){
                    buttonActive_opponent=true;
                    buttonActive_opponent1=false;
                    buttonActive_opponent2=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }  else if(randomNum==2){
                    buttonActive_opponent1=true;
                    buttonActive_opponent=false;
                    buttonActive_opponent2=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }else if(randomNum==3){
                    buttonActive_opponent2=true;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }else if(randomNum==4){
                    buttonActive_opponent2=false;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=true;
                    buttonActive_opponent4=false;
                }else if(randomNum==5){
                    buttonActive_opponent2=false;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=true;
                }
                if(randomNum==2){
                    buttonActive_win=true;
                    buttonActive_lose=false;
                    buttonActive_draw=false;
                    yourWins=yourWins+1;
                }else if(randomNum==5){
                    buttonActive_win=true;
                    buttonActive_lose=false;
                    buttonActive_draw=false;
                    yourWins=yourWins+1;
                }else if(randomNum==4) {
                    buttonActive_draw=true;
                    buttonActive_lose=false;
                    buttonActive_win=false;
                }else{
                    buttonActive_lose=true;
                    buttonActive_win=false;
                    buttonActive_draw=false;
                    computersWins=computersWins+1;
                }
            }
        }
        //------------------------------------------------------------//
        if (e.getButton() == MouseEvent.BUTTON2) {//если мы нажали правую кнопку мыши
            try {
                //Перемещаем курсор мыши в случайную часть экрана
                Robot robot = new Robot();
                Random random = new Random();
                robot.mouseMove(random.nextInt(getWidth()), random.nextInt(getHeight()));
            } catch (AWTException ex) {
            }
        }
        if (e.getButton() == MouseEvent.BUTTON1) {
            //если мы нажали левую кнопку мыши, проверяем помали ли мы на кнопку
            if (buttonActive4 &&
                    e.getX() >= buttonX4 && e.getX() <= buttonX4 + buttonW4 &&
                    e.getY() >= buttonY4 && e.getY() <= buttonY4 + buttonH4
            ) {
                buttonActive1 = false;
                buttonActive2 = false;
                buttonActive3 = false;
                buttonActive = false;
                Random salmon = new Random();
                int randomNum =  salmon.nextInt(5) + 1;
                System.out.println(randomNum);
                if(randomNum==1){
                    buttonActive_opponent=true;
                    buttonActive_opponent1=false;
                    buttonActive_opponent2=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }  else if(randomNum==2){
                    buttonActive_opponent1=true;
                    buttonActive_opponent=false;
                    buttonActive_opponent2=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }else if(randomNum==3){
                    buttonActive_opponent2=true;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=false;
                }else if(randomNum==4){
                    buttonActive_opponent2=false;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=true;
                    buttonActive_opponent4=false;
                }else if(randomNum==5){
                    buttonActive_opponent2=false;
                    buttonActive_opponent=false;
                    buttonActive_opponent1=false;
                    buttonActive_opponent3=false;
                    buttonActive_opponent4=true;
                }
                if(randomNum==1){
                    buttonActive_win=true;
                    buttonActive_lose=false;
                    buttonActive_draw=false;
                    yourWins=yourWins+1;
                }else if(randomNum==3){
                    buttonActive_win=true;
                    buttonActive_lose=false;
                    buttonActive_draw=false;
                    yourWins=yourWins+1;
                }else if(randomNum==5) {
                    buttonActive_draw=true;
                    buttonActive_lose=false;
                    buttonActive_win=false;
                }else{
                    buttonActive_lose=true;
                    buttonActive_win=false;
                    buttonActive_draw=false;
                    computersWins=computersWins+1;
                }
            }
        }
        //------------------------------------------------------------//

            //если нажали на колесико, сделать кнопку активной
        if(e.getButton() == MouseEvent.BUTTON3 ){
            buttonActive = true;
            buttonActive1 = true;
            buttonActive2 = true;
            buttonActive3 = true;
            buttonActive4 = true;
            buttonActive_opponent = false;
            buttonActive_opponent1 = false;
            buttonActive_opponent2 = false;
            buttonActive_opponent3 = false;
            buttonActive_opponent4 = false;
            buttonActive_win= false;
            buttonActive_lose= false;
            buttonActive_draw=false;
        }

    }

    //кнопка мыши нажата
    @Override
    public void mousePressed(MouseEvent e) {

    }

    //кнопка мыши отпущена
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    //курсор зашел на окно
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    //курсор вышл за пределы окна
    @Override
    public void mouseExited(MouseEvent e) {

    }

    //Мышка метеретаскиевает что-то
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    //мышка передвинулась
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

    }


    static final int w = 800;
    static final int h = 600;

    //магический код позволяющий всему работать, лучше не трогать
    public static void main(String[] args) throws InterruptedException {
        Main jf = new Main();
        jf.setSize(w, h);//размер экрана
        jf.setUndecorated(false);//показать заголовок окна
        jf.setTitle("Обалденный код Лосоя");
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.createBufferStrategy(2);

        //!!!!!!!!!!!!!!!
        jf.addMouseListener(jf);//!!!!!!добавляем слушатель к окну
        jf.addMouseMotionListener(jf);///////!!!!!!!!

        //Создаем изображение своего курсора
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        java.awt.Graphics cursorGr = cursorImg.getGraphics();
        //рисуем
        cursorGr.setColor(new Color(23, 13, 214));
        cursorGr.fillOval(0, 0, 16, 16);
        cursorGr.setColor(Color.RED);
        cursorGr.drawLine(8, 0, 8, 16);
        cursorGr.drawLine(0, 8, 16, 8);
        //инициируем курсор
        Cursor myCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "custom cursor");
        // Set cursor to the JFrame.
        jf.getContentPane().setCursor(myCursor);


        //в бесконечном цикле рисуем новый кадр
        while (true) {
            long frameLength = 1000 / 60; //пытаемся работать из рассчета  60 кадров в секунду
            long start = System.currentTimeMillis();
            BufferStrategy bs = jf.getBufferStrategy();
            Graphics2D g = (Graphics2D) bs.getDrawGraphics();
            g.clearRect(0, 0, jf.getWidth(), jf.getHeight());
            draw(g);

            bs.show();
            g.dispose();

            long end = System.currentTimeMillis();
            long len = end - start;
            if (len < frameLength) {
                Thread.sleep(frameLength - len);
            }
        }

    }


}
