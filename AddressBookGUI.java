import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
public class AddressBookGUI extends JFrame {
    private ArrayList<People> array;
    private JTextField nameField;
    private JTextField phoneField;

    private JTextField addressField;
    private JButton addButton;
    private JButton modifyButton;
    private  JButton deleyButton;
    private JButton toseeButton;

    public AddressBookGUI() {
        array = new ArrayList<>();

        // 创建组件
        JLabel nameLabel = new JLabel("姓名：");
        JLabel phoneLabel = new JLabel("电话：");
        JLabel addressLabel = new JLabel("地址：");
//按钮设计
        nameField = new JTextField(20);
        phoneField = new JTextField(20);

        addressField = new JTextField(20);
//按钮生成
        addButton = new JButton("添加成员");
        modifyButton = new JButton("修改成员");
        deleyButton=new JButton("删除成员");
        toseeButton=new JButton("查看所有");
        deleyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner sc = new Scanner(System.in);
                String phone = JOptionPane.showInputDialog("请输入要删除的通讯人电话：");
                int ture = -1;
                for (int i = 0; i < array.size(); i++) {
                    People people = array.get(i);//赋给i和ture
                    if (people.getPhone().equals(phone)) {
                        ture = i;
                        break;
                    }
                }
                if (ture == -1) {
                    JOptionPane.showMessageDialog(null, "该号码不存在 请重新输入！");
                } else {
                    array.remove(ture);
                    JOptionPane.showMessageDialog(null,"修改成功");
                }
            }
        });
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phone = JOptionPane.showInputDialog("请输入你要修改的通讯人电话号码：");
                int ture = -1;
                for (int i = 0; i < array.size(); i++) {
                    People people = array.get(i);
                    if (people.getPhone().equals(phone)) {       //方法判断字符串是否相等
                        ture = i;
                        break;
                    }
                }
                if (ture == -1) {
                    JOptionPane.showMessageDialog(null, "该号码不存在 请重新输入！");
                } else {
                    String name = JOptionPane.showInputDialog("请输入新姓名：");
                    String address = JOptionPane.showInputDialog("请输入新居住地：");
                    //创建通讯人对象
                    People p = new People();
                    p.setPhone(name);
                    p.setName(phone);
                    p.setAddress(address);
                    array.set(ture, p);
                    JOptionPane.showMessageDialog(null, "修改完成！");
                }
            }
        });

        toseeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (array.size() == 0) {
                    JOptionPane.showMessageDialog(null, "无通讯人信息，请输入信息再查看！");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < array.size(); i++) {
                    People p = array.get(i);
                    sb.append("姓名：").append(p.getName()).append("\n")
                            .append("电话号码：").append(p.getPhone()).append("\n")
                            .append("居住地：").append(p.getAddress()).append("\n")
                            .append("-----------------------").append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });


        // 添加事件监听器
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();//trim()方法来去除输入内容两端的空格
                String phone = phoneField.getText().trim();
                String address = addressField.getText().trim();
                // 判断输入是否完整
                if (name.equals("") || phone.equals("") || address.equals("")) {
                    JOptionPane.showMessageDialog(null, "请填写完整信息！");
                    return;
                }
                //判断是否重复
                for (People p : array) {
                    if (p.getPhone().equals(phone)) {
                        JOptionPane.showMessageDialog(null, "联系人已存在，请勿重复添加！");
                        return;
                    }
                }
                array.add(new People(name, phone, address));
                JOptionPane.showMessageDialog(null, "添加成功");//界面提示
            }
        });

        // 创建面板并添加组件
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));//布局设计5行二列
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(addButton);
        panel.add(modifyButton);
        panel.add(deleyButton);
        panel.add(toseeButton);
        // 设置窗口属性
        setTitle("通讯录管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出程序
        setLocationRelativeTo(null);//设置窗口相对于屏幕的位置
        setResizable(false);//设置窗口大小是否可调整
        // 将面板添加到窗口中并显示窗口
        add(panel);//添加窗口
        pack();//自动调整窗口大小以适应窗口中所有组件的大小
        setVisible(true);//显示窗口
    }
    //启动程序
    public static void main(String[] args) {
        new AddressBookGUI();
    }
}

