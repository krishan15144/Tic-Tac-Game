package tictac;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Random;

import javax.swing.*;
public class frontscreen extends Canvas
{
	
	private String ch="X";
	private int i;
	private int j;
	private int flag=0;
	private String[][] a=new String[3][3];
	JTextField userText = new JTextField(6);
	private int kite=0;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	JTextField user1=new JTextField(20);
    JTextField user2=new JTextField(20);
	private frontscreen()
	{
		for(int i=0 ; i<3 ; i++)
		{
			for(int j=0 ; j<3 ; j++)
			{
				a[i][j]="-";
			}
		}
	}
	JButton[][] ticgrid=new JButton[3][3];
	//JButton[][] ticgrid1=new JButton[3][3];
	private JFrame frame()
	{
		final JFrame f = new JFrame("Front-Screen");
		JLabel startLabel = new JLabel("Tic-Tac-Toe");
		startLabel.setBounds(150, 150, 500, 100);
		startLabel.setFont(startLabel.getFont().deriveFont(32f));	
		startLabel.setForeground(Color.GRAY);
		f.add(startLabel);
		f.setSize(500,600);
		final JButton b1=button("Start Game",150,270,200,50,16);
		final JButton b2=button("Exit",150,350,200,50,16);
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}); 
		
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{  
				final JFrame f1=new JFrame("Grid");
				f1.setSize(700,700);
				f.setVisible(false);
				f1.setVisible(true);
				f1.setBackground(new Color(0,0,0));
				final JButton gb1=button("User1 VS User2",30,100,150,50,14);  
				final JButton gb2=button("User VS CPU",30,170,150,50,14);
				final JButton gb3=button("CPU VS AI",30,240,150,50,14);
				final JButton gb4=button("User VS AI",30,310,150,50,14);
				final JButton gb5=button("EXIT",30,500,150,50,14);
			    f1.add(gb1);
			    f1.add(gb2);
			    f1.add(gb3);
			    f1.add(gb4);
			    f1.add(gb5);
			    
			    JPanel box=new JPanel(new GridLayout(3,3));
			    
			    for(int i=0 ; i<3 ; i++)
			    {
			    	for(int j=0 ; j<3 ; j++)
			    	{
			    		
			    		ticgrid[i][j]=button("",120*j+250,120*i+100,120,120,0);
			    		f1.add(ticgrid[i][j]);
			    	}
			    }
			    
			    gb1.addActionListener(new ActionListener()
			   	{
			    	frontscreen obj=new frontscreen();
			    	public void actionPerformed(ActionEvent e)
			    	{
			    		gb1.setBackground(Color.yellow);
			    		gb2.setBackground(new Color(153,204,255));
			    		gb3.setBackground(new Color(153,204,255));
			    		gb4.setBackground(new Color(153,204,255));
			    		reset(ticgrid);
					    JPanel p=new JPanel();
					    user1=new JTextField(20);
					    user2=new JTextField(20);
					    System.out.println("fhgj");
					    
					    p.add(new JLabel("User 1:"));
					    p.add(user1);
					    p.add(new JLabel("\n"));
					    p.add(new JLabel("User 2 :"));
					    p.add(user2);
					    int f = 0;
					    int a=JOptionPane.showConfirmDialog(null, p, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
					    
					    	
					    while((user1.getText().trim().length()==0 || user2.getText().trim().length()==0 || a==2))
					    {
					    	a=JOptionPane.showConfirmDialog(null, p, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
					    }
					    userText.setBounds(250, 500, 400, 60);
					    userText.setFont(new Font("Arial", Font.BOLD, 20));
					    userText.setBackground(new Color(192,192,192));
					    userText.setForeground(new Color(0,128,128));
					    f1.add(userText);
					    Object[] options = {user1.getText(),user2.getText()};
					    final int n = JOptionPane.showOptionDialog(f1,"Who would like to go first?","First one",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
					    if(n==0)
					    	userText.setText(user1.getText()+"'s Turn");
					    else
					    	userText.setText(user2.getText()+"'s Turn");
					    ticgrid[0][0].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(0,0)==0)
					    			operation(0,0,ticgrid,user1,user2,n);
					    		
					    	}
					    }
					    		 );
					    ticgrid[0][1].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(0,1)==0)
					    			operation(0,1,ticgrid,user1,user2,n);
					    	}
					    }
					    		 );
					    ticgrid[0][2].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(0,2)==0)
					    			operation(0,2,ticgrid,user1,user2,n);
					    	}
					    }
					    		 );
					    ticgrid[1][0].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(1,0)==0)
					    			operation(1,0,ticgrid,user1,user2,n);
					    	}
					    }
					    		 );
					    ticgrid[1][1].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(1,1)==0)
					    			operation(1,1,ticgrid,user1,user2,n);
					    	}
					    }
					    		 );
					    ticgrid[1][2].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(1,2)==0)
					    			operation(1,2,ticgrid,user1,user2,n);
					    	}
					    }
					    		 );
					    ticgrid[2][0].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(2,0)==0)
					    			operation(2,0,ticgrid,user1,user2,n);
					    	}
					    }
					    		 );
					    ticgrid[2][1].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(2,1)==0)
					    			operation(2,1,ticgrid,user1,user2,n);
					    	}
					    }
					    		 );
					    ticgrid[2][2].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(2,2)==0)
					    			operation(2,2,ticgrid,user1,user2,n);
					    	}
					    }
					    
					    
					    );	
			    	}
			    });
			    gb2.addActionListener(new ActionListener()
			   	{
			    	
			    	Random randomGenerator = new Random();
			    	
			    	public void actionPerformed(ActionEvent e)
			    	{
			    		gb2.setBackground(Color.yellow);
			    		gb1.setBackground(new Color(153,204,255));
			    		gb3.setBackground(new Color(153,204,255));
			    		gb4.setBackground(new Color(153,204,255));
			    		reset(ticgrid);
					    JPanel p=new JPanel();
					    final JTextField user1=new JTextField(20);
					    final JTextField user2=new JTextField(20);
					    user2.setText("CPU");
					    p.add(new JLabel("User 1:"));
					    p.add(user1);
					    p.add(new JLabel("\n"));
					    JOptionPane.showConfirmDialog(null, p, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
					    userText.setBounds(250, 500, 400, 60);
					    userText.setFont(new Font("Arial", Font.BOLD, 20));
					    userText.setBackground(new Color(192,192,192));
					    userText.setForeground(new Color(0,128,128));
					    f1.add(userText);
					    Object[] options = {"CPU",user1.getText()};
					    final int n = JOptionPane.showOptionDialog(f1,"Who would like to go first?","First one",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
					    if(n==0)
					    {
					    	userText.setText(user2.getText()+"'s Turn");
					    	cpu(ticgrid,user2,user1,n);
					    }
					    
					    ticgrid[0][0].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(0,0)==0)
					    		{
					    			operation(0,0,ticgrid,user2,user1,n);
					    			Timer timer=new Timer(0,new ActionListener(){
						    			@Override
						    			public void actionPerformed(ActionEvent e)
						    			{
						    				cpu(ticgrid,user2,user1,n);
						    			}
						    		});
						    			timer.setRepeats(false);
						    			timer.setCoalesce(false);
						    			timer.setInitialDelay(1000);
						    			timer.start();
					    		
					    			
					    		}
					    	}
					    }
					    		 );
					    ticgrid[0][1].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(0,1)==0)
					    		{
					    			operation(0,1,ticgrid,user2,user1,n);
					    			Timer timer=new Timer(0,new ActionListener(){
						    			@Override
						    			public void actionPerformed(ActionEvent e)
						    			{
						    				cpu(ticgrid,user2,user1,n);
						    			}
						    		});
						    			timer.setRepeats(false);
						    			timer.setCoalesce(false);
						    			timer.setInitialDelay(1000);
						    			timer.start();
					    		}
					    	}
					    }
					    		 );
					    ticgrid[0][2].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(0,2)==0)
					    		{
					    			operation(0,2,ticgrid,user2,user1,n);
					    			Timer timer=new Timer(0,new ActionListener(){
						    			@Override
						    			public void actionPerformed(ActionEvent e)
						    			{
						    				cpu(ticgrid,user2,user1,n);
						    			}
						    		});
						    			timer.setRepeats(false);
						    			timer.setCoalesce(false);
						    			timer.setInitialDelay(1000);
						    			timer.start();
					    		}
					    	}
					    }
					    		 );
					    ticgrid[1][0].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(1,0)==0)
					    		{
					    			operation(1,0,ticgrid,user2,user1,n);
					    			Timer timer=new Timer(0,new ActionListener(){
						    			@Override
						    			public void actionPerformed(ActionEvent e)
						    			{
						    				cpu(ticgrid,user2,user1,n);
						    			}
						    		});
						    			timer.setRepeats(false);
						    			timer.setCoalesce(false);
						    			timer.setInitialDelay(1000);
						    			timer.start();
					    		}
					    	}
					    }
					    		 );
					    ticgrid[1][1].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(1,1)==0)
					    		{
					    			operation(1,1,ticgrid,user2,user1,n);
					    			Timer timer=new Timer(0,new ActionListener(){
						    			@Override
						    			public void actionPerformed(ActionEvent e)
						    			{
						    				cpu(ticgrid,user2,user1,n);
						    			}
						    		});
						    			timer.setRepeats(false);
						    			timer.setCoalesce(false);
						    			timer.setInitialDelay(1000);
						    			timer.start();
					    		}
					    	}
					    }
					    		 );
					    ticgrid[1][2].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(1,2)==0)
					    		{
					    			operation(1,2,ticgrid,user2,user1,n);
					    			Timer timer=new Timer(0,new ActionListener(){
						    			@Override
						    			public void actionPerformed(ActionEvent e)
						    			{
						    				cpu(ticgrid,user2,user1,n);
						    			}
						    		});
						    			timer.setRepeats(false);
						    			timer.setCoalesce(false);
						    			timer.setInitialDelay(1000);
						    			timer.start();
					    		}
					    	}
					    }
					    		 );
					    ticgrid[2][0].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(2,0)==0)
					    		{
					    			operation(2,0,ticgrid,user2,user1,n);
					    			Timer timer=new Timer(0,new ActionListener(){
						    			@Override
						    			public void actionPerformed(ActionEvent e)
						    			{
						    				cpu(ticgrid,user2,user1,n);
						    			}
						    		});
						    			timer.setRepeats(false);
						    			timer.setCoalesce(false);
						    			timer.setInitialDelay(1000);
						    			timer.start();
					    		}
					    	}
					    }
					    		 );
					    ticgrid[2][1].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(2,1)==0)
					    		{
					    			operation(2,1,ticgrid,user2,user1,n);
					    			Timer timer=new Timer(0,new ActionListener(){
						    			@Override
						    			public void actionPerformed(ActionEvent e)
						    			{
						    				cpu(ticgrid,user2,user1,n);
						    			}
						    		});
						    			timer.setRepeats(false);
						    			timer.setCoalesce(false);
						    			timer.setInitialDelay(1000);
						    			timer.start();
					    		}
					    	}
					    }
					    		 );
					    ticgrid[2][2].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(2,2)==0)
					    		{
					    			operation(2,2,ticgrid,user2,user1,n);
					    			Timer timer=new Timer(0,new ActionListener(){
						    			@Override
						    			public void actionPerformed(ActionEvent e)
						    			{
						    				cpu(ticgrid,user2,user1,n);
						    			}
						    		});
						    			timer.setRepeats(false);
						    			timer.setCoalesce(false);
						    			timer.setInitialDelay(1000);
						    			timer.start();
					    		}
					    	}
					    }
					    
					    
					    );	
			    	}
			    });
			    gb3.addActionListener(new ActionListener()
			   	{
			    	Random randomGenerator = new Random();
			    	public void actionPerformed(ActionEvent e)
			    	{
			    		Runnable r=new Runnable(){
			    		public void run(){
			    			reset(ticgrid);
				    		gb3.setBackground(Color.yellow);
				    		gb2.setBackground(new Color(153,204,255));
				    		gb1.setBackground(new Color(153,204,255));
				    		gb4.setBackground(new Color(153,204,255));
						    JPanel p=new JPanel();
						    final JTextField user1=new JTextField(20);
						    final JTextField user2=new JTextField(20);
						    user2.setText("CPU");
						    user1.setText("AI user");
						    userText.setBounds(250, 500, 400, 60);
						    userText.setFont(new Font("Arial", Font.BOLD, 20));
						    userText.setBackground(new Color(192,192,192));
						    userText.setForeground(new Color(0,128,128));
						    f1.add(userText);
						    Object[] options = {"CPU","AI"};
						    final int n = JOptionPane.showOptionDialog(f1,"Who would like to go first?","First one",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
						    if(n==0)
						    {
						    	userText.setText(user2.getText()+"'s Turn");
						    	System.out.println("CPU");
						    	cpu(ticgrid,user2,user1,n);
						    	try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						    }
						    int u=0;
						    while(flag==0)
						    {
						    	System.out.println("tuyu");
						    	int i=0;
						    	int j=0;
						    	int check=0;
						    	System.out.println("AI");
						    	System.out.println(flag);
						    	for(i=0 ; i<3 ; i++)
						    	{
						    		for(j=0 ; j<3 ; j++)
						    		{
						    			if(isEmpty(i,j)==1)
						    				continue;
						    			else
						    			{
						    				if(n==0)
						    					check=checkstate(i,j,"0");
						    				else
						    					check=checkstate(i,j,"X");
						    				if(check==1)
						    				{
						    					
						    					operation(i,j,ticgrid,user2,user1,n);
						    					try {
													Thread.sleep(1000);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
						    					break;
						    				}
						    					
						    			}
						    		}
						    		if(check==1)
						    		{
						    			break;
						    		}
						    	}
						    	if(check!=1)
						    	{
						    		for(i=0 ; i<3 ; i++)
							    	{
							    		for(j=0 ; j<3 ; j++)
							    		{
							    			if(isEmpty(i,j)==1)
							    				continue;
							    			else
							    			{
							    				if(n==0)
							    					check=checkstate(i,j,"X");
							    				else
							    					check=checkstate(i,j,"0");
							    				if(check==1)
							    				{
							    					operation(i,j,ticgrid,user2,user1,n);
							    					try {
														Thread.sleep(1000);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
							    					break;
							    				}
							    					
							    			}
							    		}
							    		if(check==1)
							    		{
							    			break;
							    		}
							    	}
						    		if(check!=1)
						    		{
						    			cpu(ticgrid,user2,user1,n);
						    			try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											((Throwable) e).printStackTrace();
										}
							    		check=1;
						    		}
						    		
						    		if(check==1)
						    		{
						    			
						    			System.out.println("CPU");
						    			cpu(ticgrid,user2,user1,n);
						    			try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    		}
						    		for(long n1=0; n1<1000000000 ; n1++)
						    		{
						    			
						    		}
						    		
						    	}
						    	
						    }
						    System.out.println(flag);
						    
			    		}
			    		};
			    		
							Thread t=new Thread(r);
							t.start();
							
					}
				});
			    gb4.addActionListener(new ActionListener()
			   	{
			    	
			    	//frontscreen obj=new frontscreen();
			    	Random randomGenerator = new Random();
			    	public void actionPerformed(ActionEvent e)
			    	{
			    		reset(ticgrid);
			    		gb4.setBackground(Color.yellow);
			    		gb2.setBackground(new Color(153,204,255));
			    		gb3.setBackground(new Color(153,204,255));
			    		gb1.setBackground(new Color(153,204,255));
					    JPanel p=new JPanel();
					    final JTextField user1=new JTextField(20);
					    final JTextField user2=new JTextField(20);
					    user2.setText("AI User");
					    p.add(new JLabel("User 1:"));
					    p.add(user1);
					    p.add(new JLabel("\n"));
					    JOptionPane.showConfirmDialog(null, p, "UserNames : ", JOptionPane.OK_CANCEL_OPTION);
					    userText.setBounds(250, 500, 400, 60);
					    userText.setFont(new Font("Arial", Font.BOLD, 20));
					    userText.setBackground(new Color(192,192,192));
					    userText.setForeground(new Color(0,128,128));
					    f1.add(userText);
					    Object[] options = {"AI User",user1.getText()};
					    final int n = JOptionPane.showOptionDialog(f1,"Who would like to go first?","First one",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
					    if(n==0)
					    {
					    	
						    	AIPerform(ticgrid,user2,user1,n);
						    		
						    	
					    }
					    
					    ticgrid[0][0].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(0,0)==0)
					    		{
					    			operation(0,0,ticgrid,user2,user1,n);
					    			AIPerform(ticgrid,user2,user1,n);
					    		}
					    	}
					    }
					    		 );
					    ticgrid[0][1].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		
					    		if(isEmpty(0,1)==0)
					    		{
					    			operation(0,1,ticgrid,user2,user1,n);
					    			AIPerform(ticgrid,user2,user1,n);
					    		}
					    	}
					    }
					    		 );
					    ticgrid[0][2].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(0,2)==0)
					    		{
					    			operation(0,2,ticgrid,user2,user1,n);
					    			AIPerform(ticgrid,user2,user1,n);
					    		}
					    	}
					    }
					    		 );
					    ticgrid[1][0].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(1,0)==0)
					    		{
					    			operation(1,0,ticgrid,user2,user1,n);
					    			AIPerform(ticgrid,user2,user1,n);
					    		}
					    	}
					    }
					    		 );
					    ticgrid[1][1].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(1,1)==0)
					    		{
					    			operation(1,1,ticgrid,user2,user1,n);
					    			AIPerform(ticgrid,user2,user1,n);
					    		}
					    	}
					    }
					    		 );
					    ticgrid[1][2].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(1,2)==0)
					    		{
					    			operation(1,2,ticgrid,user2,user1,n);
					    			AIPerform(ticgrid,user2,user1,n);
					    		}
					    	}
					    }
					    		 );
					    ticgrid[2][0].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(2,0)==0)
					    		{
					    			operation(2,0,ticgrid,user2,user1,n);
					    			AIPerform(ticgrid,user2,user1,n);
					    		}
					    	}
					    }
					    		 );
					    ticgrid[2][1].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(2,1)==0)
					    		{
					    			operation(2,1,ticgrid,user2,user1,n);
					    			AIPerform(ticgrid,user2,user1,n);
					    		}
					    	}
					    }
					    		 );
					    ticgrid[2][2].addActionListener(new ActionListener()
					    {
					    	
					    	public void actionPerformed(ActionEvent e)
					    	{
					    		if(isEmpty(2,2)==0)
					    		{
					    			operation(2,2,ticgrid,user2,user1,n);
					    			AIPerform(ticgrid,user2,user1,n);
					    		}
					    	}
					    }
					    
					    
					    );	
			    	}
			    });	    
			    gb5.addActionListener(new ActionListener()
			    {
			    	public void actionPerformed(ActionEvent e)
			    	{
			    		System.exit(0);
			    	}
			    });
					    
			    f1.setLayout(null);  
				f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
				}); 
		
		f.add(b1);
		f.add(b2);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		return f;
	}
		private void AIPerform(JButton ticgrid[][],JTextField user1,JTextField user2,int n)
		{
			
				Random randomGenerator = new Random();
				int i=0;
		    	int j=0;
		    	int check=0;
		    	for(i=0 ; i<3 ; i++)
		    	{
		    		for(j=0 ; j<3 ; j++)
		    		{
		    			if(isEmpty(i,j)==1)
		    				continue;
		    			else
		    			{
		    				if(n==0)
		    					check=checkstate(i,j,"X");
		    				else
		    					check=checkstate(i,j,"0");
		    				if(check==1)
		    				{
		    					operation(i,j,ticgrid,user1,user2,n);
		    					break;
		    				}
		    					
		    			}
		    		}
		    		if(check==1)
		    		{
		    			break;
		    		}
		    	}
		    	if(check!=1)
		    	{
		    		for(i=0 ; i<3 ; i++)
			    	{
			    		for(j=0 ; j<3 ; j++)
			    		{
			    			if(isEmpty(i,j)==1)
			    				continue;
			    			else
			    			{
			    				if(n==0)
			    					check=checkstate(i,j,"0");
			    				else
			    					check=checkstate(i,j,"X");
			    				if(check==1)
			    				{
			    					operation(i,j,ticgrid,user1,user2,n);
			    					break;
			    				}
			    					
			    			}
			    		}
			    		if(check==1)
			    		{
			    			break;
			    		}
			    	}
		    		if(check!=1)
		    		{
		    			int x=randomGenerator.nextInt(3);
			    		int y=randomGenerator.nextInt(3);
			    		while(1>0 && flag==0)
			    		{
			    			if(isEmpty(x,y)==0)
			    			{
			    				System.out.println(x+" "+y);
			    				operation(x,y,ticgrid,user1,user2,n);
			    				break;
			    			}
			    			else
			    			{
			    				x=randomGenerator.nextInt(3);
			    				y=randomGenerator.nextInt(3);
			    			}
			    		}
			    		check=1;
		    		}
		    		
		    	
		    }
		}
	private void operation(int i,int j,JButton ticgrid[][],JTextField user1,JTextField user2,int n)
	{
		String h=ch;
		
		int k;
		int l=isEmpty(i,j);
		if(l==0 && flag==0)
		{
			ticgrid[i][j].setText(h);
			ticgrid[i][j].setFont(new Font("Arial", Font.BOLD, 50));
			if(ch=="X")
			{
    			ch="0";
    			if(n==0)
    				userText.setText(user2.getText()+"'s Turn");
    			else
    				userText.setText(user1.getText()+"'s Turn");
			}
    		
    		else
    		{
    			ch="X";
    			if(n==0)
    				userText.setText(user1.getText()+"'s Turn");
    			else
    				userText.setText(user2.getText()+"'s Turn");
    					
    		}
    			
			a[i][j]=h;
		}
		
			k=checkstate(i,j,h);
		
		if(k==1)
		{
			flag=1;
			kite=1;
			ticgrid[x1][y1].setForeground(new Color(255,0,0));
			ticgrid[x2][y2].setForeground(new Color(255,0,0));
			ticgrid[i][j].setForeground(new Color(255,0,0));
			if(ch=="X")
			{
				if(n==0)
    				userText.setText(user2.getText()+" Won");
    			else
    				userText.setText(user1.getText()+" Won");
			}
    		else
    		{
    			
    			if(n==0)
    				userText.setText(user1.getText()+" Won");
    			else
    				userText.setText(user2.getText()+" Won");
    		}
			//System.exit(0);
		}
		if(k==2)
		{
			flag=1;
			userText.setText("Tie");
		}			    		
		for(int i1=0 ; i1<3 ; i1++)
		{
			for(int j1=0 ; j1<3 ; j1++)
			{
				System.out.print(a[i1][j1]+" ");
			}
			System.out.println("");
		}
	}
	private int isEmpty(int x,int y)
	{
		if(a[x][y].equals("-"))
		{
			return 0;
		}
		else
			return 1;
	}
	private JButton button(String text,int x,int y,int w,int h,int fsize)
	{
		JButton b1=new JButton(text);
		b1.setBounds(x, y, w, h);
		b1.setFont(new Font("Arial", Font.BOLD, fsize));
		b1.setBackground(new Color(153,204,255));
		return b1;
	}
	private void cpu(JButton ticgrid[][],JTextField user1,JTextField user2,int n)
	{
		Random randomGenerator=new Random();
		
		int x=randomGenerator.nextInt(3);
		int y=randomGenerator.nextInt(3);
		while(1>0 && flag==0)
		{
			if(isEmpty(x,y)==0)
			{
				System.out.println(x+" "+y);
				operation(x,y,ticgrid,user1,user2,n);
				break;
			}
			else
			{
				x=randomGenerator.nextInt(3);
				y=randomGenerator.nextInt(3);
			}
		}
	}
	private void reset(JButton ticgrid[][])
	{
		
		for(int i=0 ; i<3 ; i++)
		{
			for(int j=0 ; j<3 ; j++)
			{
				a[i][j]="-";
				ticgrid[i][j].setText("");
				ticgrid[i][j].setForeground(Color.BLACK);
			}
		}
		flag=0;
		//kite=0;
		ch="X";
	}
	private int checkstate(int x,int y,String val)
	{
		
		if(x==0 && y==0)
		{
			if(a[1][0]==val && a[2][0]==val)
			{
				x1=1;
				x2=2;
				y1=y2=0;
				return 1;
			}
			else if(a[0][1]==val && a[0][2]==val)
			{
				x1=x2=0;
				y1=1;
				y2=2;
				return 1;
			}
			else if(a[1][1]==val && a[2][2]==val)
			{
				x1=1;
				x2=2;
				y1=1;
				y2=2;
				return 1;
			}
			else
			{
				int flag=0;
				for(int i=0 ; i<3 ; i++)
				{
					for(int j=0 ; j<3 ; j++)
					{
						if(a[i][j]=="-")
							flag=1;
					}
				}
				if(flag==0)
				{
					return 2;
				}
			}
		}
		if(x==0 && y==1)
		{
			if(a[0][0]==val && a[0][2]==val)
			{
				x1=0;
				x2=0;
				y1=0;
				y2=2;
				return 1;
			}
			else if(a[1][1]==val && a[2][1]==val)
			{
				x1=1;
				x2=2;
				y1=1;
				y2=1;
				return 1;
			}
			
			else	
			{
				int flag=0;
				for(int i=0 ; i<3 ; i++)
				{
					for(int j=0 ; j<3 ; j++)
					{
						if(a[i][j]=="-")
							flag=1;
					}
				}
				if(flag==0)
				{
					System.out.println("Tie");
					System.exit(0);
				}
			}
		}
		if(x==0 && y==2)
		{
			if(a[1][2]==val && a[2][2]==val)
			{
				x1=1;
				x2=2;
				y1=2;
				y2=2;
				return 1;
			}
			else if(a[0][1]==val && a[0][0]==val)
			{
				x1=0;
				x2=0;
				y1=1;
				y2=0;
				return 1;
			}
			else if(a[1][1]==val && a[2][0]==val)
			{
				x1=1;
				x2=2;
				y1=1;
				y2=0;
				return 1;
			}
			else
			{
				int flag=0;
				for(int i=0 ; i<3 ; i++)
				{
					for(int j=0 ; j<3 ; j++)
					{
						if(a[i][j]=="-")
							flag=1;
					}
				}
				if(flag==0)
				{
					return 2;
				}
			}
		}
		if(x==1 && y==0)
		{
			if(a[1][1]==val && a[1][2]==val)
			{
				x1=1;
				x2=1;
				y1=1;
				y2=2;
				return 1;
			}
			else if(a[0][0]==val && a[2][0]==val)
			{
				x1=0;
				x2=2;
				y1=0;
				y2=0;
				return 1;
			}
			else
			{
				int flag=0;
				for(int i=0 ; i<3 ; i++)
				{
					for(int j=0 ; j<3 ; j++)
					{
						if(a[i][j]=="-")
							flag=1;
					}
				}
				if(flag==0)
				{
					return 2;
				}
			}
		}
		if(x==1 && y==1)
		{
			if(a[1][0]==val && a[1][2]==val)
			{
				x1=1;
				x2=1;
				y1=0;
				y2=2;
				return 1;
			}
			else if(a[0][0]==val && a[2][2]==val)
			{
				x1=0;
				x2=2;
				y1=0;
				y2=2;
				return 1;
			}
			else if(a[0][2]==val && a[2][0]==val)
			{
				x1=0;
				x2=2;
				y1=2;
				y2=0;
				return 1;
			}
			else if(a[0][1]==val && a[2][1]==val)
			{
				x1=0;
				x2=2;
				y1=1;
				y2=1;
				return 1;
			}
			else
			{
				int flag=0;
				for(int i=0 ; i<3 ; i++)
				{
					for(int j=0 ; j<3 ; j++)
					{
						if(a[i][j]=="-")
							flag=1;
					}
				}
				if(flag==0)
				{
					return 2;
				}
			}
		}
		if(x==1 && y==2)
		{
			if(a[2][2]==val && a[0][2]==val)
			{
				x1=2;
				x2=0;
				y1=2;
				y2=2;
				return 1;
			}
			else if(a[1][0]==val && a[1][1]==val)
			{
				x1=1;
				x2=1;
				y1=0;
				y2=1;
				return 1;
			}
			else
			{
				int flag=0;
				for(int i=0 ; i<3 ; i++)
				{
					for(int j=0 ; j<3 ; j++)
					{
						if(a[i][j]=="-")
							flag=1;
					}
				}
				if(flag==0)
				{
					return 2;
				}
			}
			
		}
		if(x==2 && y==0)
		{
			if(a[2][1]==val && a[2][2]==val)
			{
				x1=2;
				x2=2;
				y1=1;
				y2=2;
				return 1;
			}
			else if(a[0][0]==val && a[1][0]==val)
			{
				x1=0;
				x2=1;
				y1=0;
				y2=0;
				return 1;
			}
			else if(a[1][1]==val && a[0][2]==val)
			{
				x1=1;
				x2=0;
				y1=1;
				y2=2;
				return 1;
			}
			else
			{
				int flag=0;
				for(int i=0 ; i<3 ; i++)
				{
					for(int j=0 ; j<3 ; j++)
					{
						if(a[i][j]=="-")
							flag=1;
					}
				}
				if(flag==0)
				{
					return 2;
				}
			}
		}
		if(x==2 && y==1)
		{
			if(a[2][0]==val && a[2][2]==val)
			{
				x1=2;
				x2=2;
				y1=0;
				y2=2;
				return 1;
			}
			else if(a[1][1]==val && a[0][1]==val)
			{
				x1=1;
				x2=0;
				y1=1;
				y2=1;
				return 1;
			}
			else
			{
				int flag=0;
				for(int i=0 ; i<3 ; i++)
				{
					for(int j=0 ; j<3 ; j++)
					{
						if(a[i][j]=="-")
							flag=1;
					}
				}
				if(flag==0)
				{
					return 2;
				}
			}
		}
			
		
		if(x==2 && y==2)
		{
			if(a[1][2]==val && a[0][2]==val)
			{
				x1=1;
				x2=0;
				y1=2;
				y2=2;
				return 1;
			}
			else if(a[2][0]==val && a[2][1]==val)
			{
				x1=2;
				x2=2;
				y1=0;
				y2=1;
				return 1;
			}
			else if(a[1][1]==val && a[0][0]==val)
			{
				x1=1;
				x2=0;
				y1=1;
				y2=0;
				return 1;
			}
			else
			{
				int flag=0;
				for(int i=0 ; i<3 ; i++)
				{
					for(int j=0 ; j<3 ; j++)
					{
						if(a[i][j]=="-")
							flag=1;
					}
				}
				if(flag==0)
				{
					return 2;
				}
			}
		}
		return 0;
	}
	public static void main(String[] args)
	{
		frontscreen j=new frontscreen();
		JFrame f=j.frame();
		f.add(j);
		
	}

}
