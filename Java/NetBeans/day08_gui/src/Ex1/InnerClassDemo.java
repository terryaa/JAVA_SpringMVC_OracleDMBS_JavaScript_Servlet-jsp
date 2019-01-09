/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

/**
 *
 * @author younghoonkim
 */



import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//익명내부클래스로 처리한다.

/**
 *
 * @author KOSTA
 * 지금까지 학습한 내부 클래스를 활용하는 방법에 대해서 알아보자
 */
public class InnerClassDemo extends JFrame {
    //JFrame을 상속받아서 GUI 화면을 구상하는 클래스를 정의
    private JPanel p1,p2;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    String red;
    //Alt + insert
    public InnerClassDemo(){
        //선언한 GUI객체를 초기화(생성)
        p1 = new JPanel();
        p2 = new JPanel();
        b1 = new JButton("red");
        b2 = new JButton("green");
        b3 = new JButton("blue");
        
        
        b1.setBackground(Color.red);
        b2.setBackground(Color.green);
        b3.setBackground(Color.red);
        // p1, p2에 배경색을 적용
        p1.setBackground(Color.white);
        
        //p2패널에 버튼을 배치
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        
        
        //JFrame에 p1, p2 패널을 배치
        add(p1);
        add(p2,BorderLayout.SOUTH);
        
        //화면 활성화 및 종료처리
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 450);
        setVisible(true);
        //버튼에 이벤트를 강지하도록 설정
        //b1.addActionListener(ActionListener인터페이스를 구현한 객체의 주소값);
        //주소가 InnerClassDemo이다.
//        b1.addActionListener(this);//여기서 this는 인터페이스를 구현한 / actionlistner를 구현한 인터페이스. 
//                                    //implements ActionListener << 다형성. 이거 살아있어서 가능한 것.
//        b2.addActionListener(this);
//        b3.addActionListener(this);
//익명내부클래스로 인지를 전달
b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    }
    public static void main(String[] args) {
        new InnerClassDemo();
    }
    //버튼을 green버튼, blue 각각 추가하고 해당 색상을 p1의 배경색을 지정하시오

    
    
//ActionListner 인터페이스의 추상 메서드를 재정의한다.
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // shift.del <-한줄제거
//        //System.out.println("Click!");
//        JButton btn = (JButton) e.getSource();
//       p1.setBackground(btn.getBackground());
//        
//    }
}