package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGui extends JFrame {
    JLabel labelLogin = new JLabel("");
    JLabel labelUsername = new JLabel("Username");
    JLabel labelPassword = new JLabel("Password");
    JTextField fieldUsername = new JTextField();
    JPasswordField fieldPassword = new JPasswordField();
    JButton btnLogin = new JButton("LOGIN");
    Image image = new ImageIcon(this.getClass().getResource("images/icons8-user-90.png")).getImage();
    Image image1 = new ImageIcon(this.getClass().getResource("images/icons8-user-30.png")).getImage();
    Image image2 = new ImageIcon(this.getClass().getResource("images/icons8-password-key-30.png")).getImage();

    LoginGui(){
        initComponent();
    }

    public void initComponent(){
      setBounds(100, 100, 479, 479);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setLayout(null);

      //IconLabeLogin
      labelLogin.setIcon(new ImageIcon(image));
      labelLogin.setBounds(188, 59, 97, 80);
      this.add(labelLogin);

      //IconLabelUsername
      labelUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
      labelUsername.setIcon(new ImageIcon(image1));
      labelUsername.setBounds(37, 193, 131, 44);
      this.add(labelUsername);

      //IconLabelPassword
      labelPassword.setIcon(new ImageIcon(image2));
      labelPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
      labelPassword.setBounds(37, 281, 131, 29);
      this.add(labelPassword);

      //FieldUsername
      fieldUsername.setBounds(182, 200, 227, 29);
      this.add(fieldUsername);

      //FieldPassword
      fieldPassword.setBounds(178, 284, 231, 24);
      this.add(fieldPassword);

      //BtnLogin
      btnLogin.setBackground(Color.CYAN);
      btnLogin.setForeground(Color.black);
      btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
      btnLogin.setBounds(188, 345, 117, 37);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = fieldUsername.getText();
                String password = fieldPassword.getText();
                int loginPegawai = AllObjectController.pegawaiController.Login(username,password);


                if(username.isEmpty() == true || password.isEmpty() == true){
                    JOptionPane.showMessageDialog(null,"Tidak Boleh kosong");
                }else {
                    if(loginPegawai > 0){
                        dispose();
                        new DashboardGui(loginPegawai);
                    }else {
                        JOptionPane.showMessageDialog(null,"Username atau password salah");
                        fieldUsername.setText(null);
                        fieldPassword.setText(null);
                    }
                }
            }
        });
      this.add(btnLogin);
      setVisible(true);
    }

    public static void main(String[] args) {
       new LoginGui();
    }
}
