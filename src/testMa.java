import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by gsv on 23.10.2015.
 */
public class testMa {
    private static Pattern restorePattern = Pattern.compile(
            "^(?<gg>\\d{1,3})\\s*[�]\\s* (?<mm>\\d{1,2})\\s*[\']\\s*(?<ss>\\d{1,2})\\s*[\"]\\s*?",
            Pattern.CASE_INSENSITIVE);

    private JPanel GL_panel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    ImagePanel imagePanel;

    private JPanel panel_menu;
    private JPanel panel_Work;

    private static JFrame frame;


    Point startMousePoint;


    public testMa() {
        // ��������� � ������� ������ �� �����
        GL_panel.setLayout(new BorderLayout());
        panel_menu = new JPanel();
        GL_panel.add(panel_menu, BorderLayout.NORTH);

        panel_menu.setLayout( new FlowLayout(FlowLayout.LEFT));
        button1 = new JButton();
        button1.setText("hehe");
        panel_menu.add(button1);
        button2 = new JButton("Button 2");
        panel_menu.add(button2);

        panel_Work = new JPanel();
        panel_Work.setSize(400, 400);
        GL_panel.add(panel_Work, BorderLayout.CENTER);
        panel_Work.setLayout(new GridLayout(1,1));

       //frame.setSize(100, 100);
        //frame.resize(100, 100);
        frame.repaint();

        imagePanel = new ImagePanel();
        panel_Work.add(imagePanel);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    imagePanel.setImage(ImageIO.read(new File("card.jpg")));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                panel_Work.repaint();

                ImageObserver observer = new ImageObserver() {
                    @Override
                    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                        return false;
                    }
                };

                int width = imagePanel.getImage().getWidth(observer);
                int height = imagePanel.getImage().getHeight(observer);
                //frame.setSize(width+frame.getWidth(), height+frame.getHeight());

                //frame.resize(width+100,height+100);
                frame.resize(400,400);
                frame.repaint();
            }
        });

        imagePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.isShiftDown())
                {
                    startMousePoint = e.getPoint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isShiftDown()) {
                    Point endMousePoint = e.getPoint();
                    /// ���� set center map...
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        imagePanel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int mouserot = e.getWheelRotation();
                // ���������� �������� ������� �� ���� ��� + �� ���� - zoom
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("testMa");
        frame.setContentPane(new testMa().GL_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //textField1 = new JTextField();
        //button1 = new JButton();
        //imagePanel = new ImagePanel();
        //GL_panel.add(imagePanel);
        //mapControl = new MapControl(imagePanel);

    }
}
