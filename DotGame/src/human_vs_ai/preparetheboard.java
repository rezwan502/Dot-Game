/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package human_vs_ai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.applet.Applet;
import javax.swing.Box;
import javax.swing.SwingConstants;
/**
 *
 * @author ASUS
 */
public class preparetheboard {

    final int sz = 15;
    int player = 1 , board[][] = new int[sz][sz] ,scoreofblack=0 , scoreofred=0 ,click=0;
    boolean color[][]=new boolean[sz][sz];
    JFrame frm = new JFrame("Dots");
    
    JPanel container=new JPanel();
    JPanel buttonholder = new JPanel();
    JPanel alloptions=new JPanel();
    JPanel scorecard=new JPanel();
    JPanel playerturn=new JPanel();
    JPanel extra=new JPanel();
    JPanel welcome=new JPanel();
    JPanel picture=new JPanel();
    JPanel spa = new JPanel();
    JPanel bottom=new JPanel();
    JPanel spaa=new JPanel();
    
    JButton btn[][] = new JButton[sz][sz];
    JButton restart=new JButton("End Game");
    JButton instruction=new JButton("Instructions");
    JButton enter=new JButton();
   // JButton highscore=new JButton();
    
    Icon red = new ImageIcon("F:\\JavaProjects\\human vs ai\\src\\human_vs_ai\\images\\red1.png");
    Icon black = new ImageIcon("F:\\JavaProjects\\human vs ai\\src\\human_vs_ai\\images\\blk1.png");
    Icon red2 = new ImageIcon("F:\\JavaProjects\\human vs ai\\src\\human_vs_ai\\images\\red2.png");
    Icon black2 = new ImageIcon("F:\\JavaProjects\\human vs ai\\src\\human_vs_ai\\images\\blk2.png");
    ImageIcon exp=new ImageIcon("F:\\JavaProjects\\human vs ai\\src\\human_vs_ai\\images\\capture.png");
    Icon frnt=new ImageIcon("F:\\JavaProjects\\human vs ai\\src\\human_vs_ai\\images\\game_example.gif");
            
    JLabel playerturn_lbl1=new JLabel(" player's turn ");
    JLabel playerturn_lbl2=new JLabel(red);
    JLabel scorecard_black=new JLabel("Black's  Score  :  ");
    JLabel scorecard_red=new JLabel("Red's     Score  :  ");
    JLabel score_black=new JLabel("0");
    JLabel score_red=new JLabel("0");
    JLabel frontimage=new JLabel();
    
    
    
    preparetheboard() {
        
        instruction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "#This is a two player game\n"
                        + "#player have to choose a block color (RED or BLACK)\n"
                        + "#primary target of Blocks is capturing enemy blocks by surrounding them with a continuous line of one's own blocks.\n"
                        + "#To form a chain blockss must be adjacent to each other either vertically, horizontally or diagonally.\n"
                        + "#Surrounded enemy blocks are added to the score of the player who surrounded them (but his own blocks are not counted)\n"
                        + "#Once surrounded, blocks are not playable.\n"
                        + "#surrounded blocks center will be colored with opponent block color\n" , "Instructions", 1,exp);
                   
            }
        });
        
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(click<(sz*sz))
                {
                    int reply=JOptionPane.showConfirmDialog(null, "Current game is not over .\nDo you want to End The Game ?", "Game is not over", JOptionPane.YES_NO_OPTION);
                    if(reply==JOptionPane.YES_OPTION)
                    {
                        status();
                        frm.dispose();
                        preparetheboard brd = new preparetheboard();
                    }
                }
                else
                {
                    frm.dispose();
                    preparetheboard brd = new preparetheboard();
                }  
            }
        });
        
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                frm.getContentPane().removeAll();
                frm.add(container);
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setSize(700, 700);
                frm.setResizable(false);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
     
            }
        });
        
    //    highscore.addActionListener(new ActionListener() {
     //       @Override
        //    public void actionPerformed(ActionEvent ae) {
      //          
     //       }
    //    });
        
        for(int i=0;i<sz;i++)
        {
            for(int j=0;j<sz;j++)
            {
                board[i][j]=0;
                btn[i][j]=new JButton();
                btnaction(btn[i][j], i, j);
                buttonholder.add(btn[i][j]);
            }
        }
        
        buttonholder.setPreferredSize(new Dimension(700, 700));
        buttonholder.setLayout(new GridLayout(sz, sz));
        
        //scorecard.setLayout(new BoxLayout(scorecard, BoxLayout.Y_AXIS));
        scorecard.setBackground(Color.LIGHT_GRAY);
        scorecard.setLayout(new GridLayout(2, 2));
        scorecard.add(scorecard_black);
        scorecard.add(score_black);
        scorecard.add(scorecard_red);
        scorecard.add(score_red);
        
        //playerturn.setLayout(new BoxLayout(playerturn, BoxLayout.X_AXIS));
        playerturn.setBackground(Color.LIGHT_GRAY);
        playerturn.add(playerturn_lbl1);
        playerturn.add(playerturn_lbl2);
        
        //extra.setLayout(new BoxLayout(extra, BoxLayout.Y_AXIS));
        extra.setBackground(Color.LIGHT_GRAY);
        extra.add(restart);
        extra.add(instruction);
        
        alloptions.setLayout(new BoxLayout(alloptions, BoxLayout.X_AXIS));
        alloptions.add(scorecard);
        alloptions.add(playerturn);
        alloptions.add(extra);
        
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(buttonholder);
        container.add(alloptions);
        
        picture.setPreferredSize(new Dimension(700,700));
        spa.setPreferredSize(new Dimension(700,500));
        
        enter.setPreferredSize(new Dimension(100,50));
        JLabel label = new JLabel("Play");
        label.setFont(new Font("Serif", Font.CENTER_BASELINE, 35));
        
      //  JLabel label1 = new JLabel("High Score");
      //  label1.setFont(new Font("Serif", Font.CENTER_BASELINE, 35));
        
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
     //   label1.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        label.setForeground(Color.BLUE);
       // label1.setForeground(Color.ORANGE);
        
        enter.add(label);
        enter.setBackground(Color.WHITE);
        
     //   highscore.add(label1);
     //   highscore.setBackground(Color.WHITE);
        frontimage.setIcon(frnt);
        //frontimage.setPreferredSize(new Dimension(250,450));
        
        bottom.setLayout(new GridLayout(1,1,80,0));
        
        spa.setBackground(Color.LIGHT_GRAY);
        spaa.setBackground(Color.BLUE);
        picture.setBackground(Color.LIGHT_GRAY);
        frm.setBackground(Color.LIGHT_GRAY);
        bottom.setBackground(Color.LIGHT_GRAY);
        
        JLabel dots = new JLabel("The Dots !!!!");
        dots.setFont(new Font("Serif", Font.ITALIC, 35));
        
        spa.setLayout(new BoxLayout(spa,BoxLayout.Y_AXIS));
        
        spa.add(Box.createRigidArea(new Dimension(0,50)));       
        spa.add(dots);  
        spa.add(Box.createRigidArea(new Dimension(0,40))); 
        spa.add(frontimage);
        
        dots.setAlignmentX(Component.CENTER_ALIGNMENT);
        frontimage.setAlignmentX(Component.CENTER_ALIGNMENT);
                 
        welcome.add(spa);
        bottom.add(enter);
       // bottom.add(highscore);
        picture.add(welcome);
        picture.add(bottom);
        frm.add(picture);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(700, 700);
        frm.setResizable(false);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    final void btnaction(JButton tmpbtn, int a,int b) {
        tmpbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                seticon(a,b);
            }
        });
    }

    void seticon(int a,int b) {
      
        if (board[a][b] == 0) {
            
            if (player == 1) 
            {
                
                board[a][b]=player;
                
                if(iamsafe(a,b))
                {
                   btn[a][b].setIcon(red); 
                   block_the_opponent(player);
                }
                else    
                {
                    btn[a][b].setIcon(red2);
                    board[a][b]=3;
                    scoreofblack+=1;
                    score_black.setText(Integer.toString(scoreofblack));
                }
                   
                playerturn_lbl2.setIcon(black);  //for player's turn
                player = 2;
                
            } 
            else 
            {
                
                board[a][b]=player;
        
                if(iamsafe(a,b))
                {
                   btn[a][b].setIcon(black); 
                   block_the_opponent(player);
                }
                else
                {
                    btn[a][b].setIcon(black2);
                    board[a][b]=3;
                    scoreofred+=1;
                    score_red.setText(Integer.toString(scoreofred));
                }
                
                playerturn_lbl2.setIcon(red); //for player's turn
                player = 1;
                   
            }
            click++;
        }
        if(click==(sz*sz))
        {
            status();
        }
    }
    
    boolean iamsafe(int i,int j)
    {
        colormemset();
        boolean ans = false;
        if(board[i][j]==1)        
        {
            ans=escaped(i, j, 2);
        }
        else if(board[i][j]==2)
        {
            ans=escaped(i, j, 1);
        }
        return ans;
    }
    
    void colormemset()
    {
        for(int i=0;i<sz;i++)
            for(int j=0;j<sz;j++)
                color[i][j]=false;
    }
    
    
    void block_the_opponent(int current_player)
    {
        for(int i=0;i<sz;i++)
        {
            for(int j=0;j<sz;j++)
            {
                if(current_player==1 && board[i][j]==2)
                {
                    colormemset();
                    if(!escaped(i,j,current_player))  //checking if opponent on board[i][j] can escape
                    {
                        board[i][j]=3;
                        btn[i][j].setIcon(black2);
                        scoreofred+=1;
                        score_red.setText(Integer.toString(scoreofred));
                    }
                }
                else if(current_player==2 && board[i][j]==1)
                {
                    colormemset();
                    if(!escaped(i,j,current_player))  //checking if opponent on board[i][j] can escape
                    {
                        board[i][j]=3;
                        btn[i][j].setIcon(red2);
                        scoreofblack+=1;
                        score_black.setText(Integer.toString(scoreofblack));
                    }
                }
            }
        }
    }
    
    boolean escaped(int i,int j,int current_player)  //escaped(opponent_i , opponent_j , current_player) 
    {
        if(board[i][j]==current_player || board[i][j]==3)
            return false;
        if(i==0 || i==sz-1 || j==0 ||j==sz-1)
            return true;
        if(color[i][j]==true)
            return false;
        
        color[i][j]=true;
        
        if(escaped(i+1,j,current_player))return true;
        if(escaped(i-1,j,current_player))return true;
        if(escaped(i,j+1,current_player))return true;
        if(escaped(i,j-1,current_player))return true;
        
        if(board[i-1][j]!=current_player || board[i][j-1]!=current_player)
            if(escaped(i-1,j-1,current_player))return true;
        if(board[i][j-1]!=current_player || board[i+1][j]!=current_player)
            if(escaped(i+1,j-1,current_player))return true;
        if(board[i-1][j]!=current_player || board[i][j+1]!=current_player)
            if(escaped(i-1,j+1,current_player))return true;
        if(board[i+1][j]!=current_player || board[i][j+1]!=current_player)
            if(escaped(i+1,j+1,current_player))return true;
        
        return false;
    }
    
    void status()
    {
        if(scoreofblack>scoreofred)
            {
                JOptionPane.showMessageDialog(null, "Game Over\n\n BLACK Wins", "current game result", 1);
            }
            else if(scoreofblack<scoreofred)
            {
                JOptionPane.showMessageDialog(frm, "Game Over\n\n RED Wins","current game result", 1);
            }
            else
            {
                JOptionPane.showMessageDialog(frm, "Game Over\n\n it's a DRAW","current game result", 1);
            }
    }
}
