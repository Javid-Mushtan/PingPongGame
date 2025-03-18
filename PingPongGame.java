import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PingPongGame extends JPanel implements KeyListener, Runnable{

	static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int PADDLE_WIDTH = 10;
    static final int PADDLE_HEIGHT = 100;
    static final int BALL_SIZE = 20;
    static final int PADDLE_SPEED = 5;
    static final int BALL_SPEED = 3;

    private int paddle1Y = HEIGHT / 2 - PADDLE_HEIGHT / 2;
    private int paddle2Y = HEIGHT / 2 - PADDLE_HEIGHT / 2;
    private int ballX = WIDTH / 2 - BALL_SIZE / 2;
    private int ballY = HEIGHT / 2 - BALL_SIZE / 2;
    private int ballXDir = BALL_SPEED;
    private int ballYDir = BALL_SPEED;
    private int score1 = 0;
    private int score2 = 0;
    
    boolean up1 = false;
    boolean down1 = false;
    boolean up2 = false;
    boolean down2 = false;
    
    boolean gamePaused = false;
    public JButton continueButton,terminateButton;
    public JLabel label,looser;
    public JPanel scorecard;
    
	PingPongGame(){
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		addKeyListener(this);
		
		continueButton = new JButton("Continue");
        terminateButton = new JButton("Terminate");
        label = new JLabel();
        looser = new JLabel();
        scorecard = new JPanel();
        
        continueButton.setBounds(WIDTH / 2 - 80, HEIGHT / 2 - 30, 100, 40);
        terminateButton.setBounds(WIDTH / 2 + 20, HEIGHT / 2 - 30, 100, 40);
        scorecard.setBounds(WIDTH / 2 - 78 , HEIGHT / 2 + 20, 200, 100);
        label.setForeground(Color.GREEN);
        looser.setForeground(Color.RED);
        label.setFont(new Font("Times New Roman",Font.BOLD,20));
        looser.setFont(new Font("Times New Roman",Font.BOLD,20));
        
        scorecard.setFocusable(false);
        continueButton.setFocusable(true);
        terminateButton.setFocusable(true);
        label.setFocusable(false);
        looser.setFocusable(false);
        
        continueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					paused();
					scorecard.setVisible(false);
			}
		});
        
        terminateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					System.exit(0);
			}
		});
        
        looser.setVisible(true);
        label.setVisible(true);
        scorecard.add(looser);
        scorecard.add(label);
        this.add(scorecard);
        this.setLayout(null);
        this.add(continueButton);
        this.add(terminateButton);
        
        scorecard.setVisible(false);
        continueButton.setVisible(false);
        terminateButton.setVisible(false);
	}
	
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect( 0, paddle1Y, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.fillRect( WIDTH - PADDLE_WIDTH, paddle2Y, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
		
		g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Player 1: " + score1, 50, 50);
        g.drawString("Player 2: " + score2, WIDTH - 250, 50);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_W) {
			up1 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			down1 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			up2 = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			down2 = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_W) {
			up1 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			down1 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			up2 = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			down2 = false;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
			if(!gamePaused) {
				if(up1 && paddle1Y > 0) {
					paddle1Y -= PADDLE_SPEED;
				}
				if (down1 && paddle1Y < HEIGHT - PADDLE_HEIGHT) {
					paddle1Y += PADDLE_SPEED;
				}
				if (up2 && paddle2Y > 0) {
					paddle2Y -= PADDLE_SPEED;
				}
		        if (down2 && paddle2Y < HEIGHT - PADDLE_HEIGHT) {
		        	paddle2Y += PADDLE_SPEED;
		        }
		        
		        ballX += ballXDir;
		        ballY += ballYDir;
		        
		        if(ballY <= 0 || ballY >= HEIGHT - BALL_SIZE) {
		        	ballYDir = -ballYDir;
		        }
		        
		        if (ballX <= PADDLE_WIDTH && ballY + BALL_SIZE >= paddle1Y && ballY <= paddle1Y + PADDLE_HEIGHT) {
		            ballXDir = BALL_SPEED;
		            score1++;
		        }
		        if (ballX >= WIDTH - PADDLE_WIDTH - BALL_SIZE && ballY + BALL_SIZE >= paddle2Y && ballY <= paddle2Y + PADDLE_HEIGHT) {
		            ballXDir = -BALL_SPEED;
		            score2++;
		        }
		        
		        if(ballX <= 0 || ballX >= WIDTH - BALL_SIZE) {
		        	gamePaused = true;
		        	continueButton.setVisible(true);
		            terminateButton.setVisible(true);
		            if(score1 > score2) {
		            	label.setText("Winner is player1...");
		            	looser.setText("Looser is player2...");
		            } else if(score1 < score2) {
		            	label.setText("Winner is player2...");
		            	looser.setText("Looser is player1...");
		            } else {
		            	label.setText("Its Not Far");
		            	looser.setText("Match Is Draw");
		            }
		            scorecard.setVisible(true);
		        	score1 = 0;
		        	score2 = 0;
		        	resetball();
		        }
			}
	        
	        repaint();
	        try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void paused() {
		gamePaused = false;
    	continueButton.setVisible(false);
    	terminateButton.setVisible(false);
	}
	
	public void resetball() {
		ballX = WIDTH / 2 - BALL_SIZE / 2;
	    ballY = HEIGHT / 2 - BALL_SIZE / 2;
	    ballXDir = BALL_SPEED * -1;
        ballYDir = BALL_SPEED * -1;
	}
	
	public static void main(String[] args) {
        JFrame frame = new JFrame("Ping Pong Game");
        PingPongGame game = new PingPongGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Thread gameThread = new Thread(game);
        gameThread.start();
    }
}
