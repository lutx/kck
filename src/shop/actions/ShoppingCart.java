package shop.actions;
import java.util.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.table.*;
import shop.db.Model;
public class ShoppingCart implements CustomApp {

    private ProductItemGUI productItemGUI;
    State state;

    @Override
    public void runApp() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        ProductDB productDB = new ProductDB();
        productItemGUI = new ProductItemGUI(this);
        CartItem cart = new CartItem();
        ProductItemController  productItemController = new ProductItemController(this, productItemGUI,productDB,cart);
        productItemGUI.setVisible(true);
    }
    @Override
    public void stopApp() {
        productItemGUI.close();
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void changeApp(CustomApp app) {
        this.state.changeState(app);
    }


}

class ProductItemGUI extends JFrame {
    private JLabel pmenu,cartItem,qStock,num,price,totalPrice;
    private DefaultListModel<String> myListModel;
    private JList<String> list;
    private JScrollPane scrollPane,scrollPane2;
    private JComboBox<String> callNum;
    private JButton add,checkout,remove,clear,exit,console;
    private JTable table;
    private DefaultTableModel defaultModel;
    private JPanel panel,panel2;
    private CustomApp parent;

    public ProductItemGUI(CustomApp parent) {
        this.parent = parent;
        this.setTitle("Best Shop");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,100,600,380);
        this.getContentPane().setBackground(Color.white);
        this.setPreferredSize(new Dimension(600, 380));
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setIconImage(this.getToolkit().getImage("actions/icon.jpg"));

        pmenu = new JLabel("Product Menu");
        Font font1 = new Font(Font.DIALOG, Font.BOLD, 13);
        pmenu.setFont(font1);
        myListModel = new DefaultListModel<>();
        list = new JList<>(myListModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListCellRenderer renderer1 = (DefaultListCellRenderer) list.getCellRenderer();
        renderer1.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane = new JScrollPane(list);
        qStock = new JLabel("");
        price = new JLabel("");
        num = new JLabel("Choose Quantity");
        callNum = new JComboBox<>();
        callNum.addItem("1");
        callNum.addItem("2");
        callNum.addItem("3");
        callNum.addItem("4");
        callNum.addItem("5");
        add = new JButton("Add Product  >>");
        add.setBackground(Color.GREEN);

        cartItem = new JLabel("Cart Item");
        Font font2 = new Font(Font.DIALOG, Font.BOLD, 13);
        cartItem.setFont(font2);
        totalPrice = new JLabel();
        String[][] productInfo = new String[0][2];
        String[] names = {"Product","Quantity"};
        defaultModel = new DefaultTableModel(productInfo, names){
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
        table = new JTable(defaultModel);
        TableColumn col = table.getColumnModel().getColumn(0);
        int width = 150;
        col.setPreferredWidth(width);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        DefaultTableCellRenderer render2 = new DefaultTableCellRenderer();
        render2.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumn("Product").setCellRenderer(render2);
        table.getColumn("Quantity").setCellRenderer(render2);

        scrollPane2 = new JScrollPane(table);
        remove = new JButton("Remove Item");
        clear = new JButton("Clear Cart");
        checkout = new JButton("Check out");
        checkout.setBackground(Color.GREEN);
        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        console=new JButton("Console");
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(""));
        panel.setOpaque(false);
        panel.setLayout(null);
        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createTitledBorder(""));
        panel2.setOpaque(false);
        panel2.setLayout(null);

        pmenu.setBounds(10,10,100,20);
        scrollPane.setBounds(25,30,250,180);
        qStock.setBounds(100,210,100,20);
        price.setBounds(200,210,100,20);
        num.setBounds(50,280,120,20);
        callNum.setBounds(180,280,50,20);
        add.setBounds(70,320,140,20);

        cartItem.setBounds(310,10,100,20);
        scrollPane2.setBounds(325,30,250,180);
        remove.setBounds(325,210,125,20);
        clear.setBounds(450,210,125,20);
        totalPrice.setBounds(400,265,100,20);
        checkout.setBounds(450,320,120,20);
        exit.setBounds(380,320,60,20);
        console.setBounds(390,290,90,20);
        panel.setBounds(0,0,300,380);
        panel2.setBounds(300,0,300,380);

        panel.add(pmenu);
        panel.add(scrollPane);
        panel.add(qStock);
        panel.add(price);
        panel.add(num);
        panel.add(callNum);
        panel.add(add);
        panel2.add(checkout);
        panel2.add(exit);
        panel2.add(console);
        panel2.add(cartItem);
        panel2.add(totalPrice);
        panel2.add(scrollPane2);
        panel2.add(remove);
        panel2.add(clear);
        this.add(panel);
        this.add(panel2);

        this.pack();
    }

    public void addCheckoutListener(ActionListener listener){
        checkout.addActionListener(listener);
    }
    public void addConsoleListener(ActionListener listener){
        console.addActionListener(listener);
    }

    public void addListListener(ListSelectionListener listener){
        list.addListSelectionListener(listener);
    }

    public void addAddListener(ActionListener listener){
        add.addActionListener(listener);
    }

    public void addRemoveListener(ActionListener listener){
        remove.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener){
        clear.addActionListener(listener);
    }

    public void addExitListener(ActionListener listener){
        exit.addActionListener(listener);
    }

    public void addListElement(String s){
        myListModel.addElement(s);
    }

    public void setQStock(String s){
        qStock.setText(s);
    }

    public void setPrice(String s){
        price.setText(s);
    }

    public int getCallNum(){
        return Integer.parseInt((String)callNum.getSelectedItem());
    }

    public String getListValue(){
        return String.valueOf(list.getSelectedValue());
    }

    public void addRow(Product p){
        defaultModel.addRow(new String[]{p.getProductName(),String.valueOf(p.getSell())});
    }

    public void setRow(int id,Product p){//!!
        defaultModel.setValueAt(String.valueOf(p.getSell()),id,1);
    }

    public int getTableRow(){
        return (Integer)table.getSelectedRow();
    }

    public int getTableColumn(){
        return (Integer)table.getSelectedColumn();
    }

    public String getTableName(int r){
        return String.valueOf(table.getValueAt(r,0));
    }

    public int getTableNum(int r){
        return Integer.parseInt(String.valueOf(table.getValueAt(r,1)));
    }

    public void defaultModelRemoveRow(){
        defaultModel.removeRow((Integer)table.getSelectedRow());
    }

    public void setTableNull(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public boolean getTableIsNull(){
        return table.getRowCount()==0;
    }

    public void setTotalPrice(String s){
        totalPrice.setText(s);
    }

    public void close() {
        this.dispose();
    }
}

class CheckoutGUI extends JFrame{
    private JButton show,shop,exit;
    private JLabel wJLabel;
    private JTextArea jTA;
    private JScrollPane scrollPane;

    public CheckoutGUI() {
        this.setTitle("Check Out");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100,100,300,400);
        this.getContentPane().setBackground(Color.white);
        this.setPreferredSize(new Dimension(300, 400));
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setIconImage(this.getToolkit().getImage("icon.jpg"));

        jTA = new JTextArea();
        jTA.setLineWrap(true);
        scrollPane = new JScrollPane(jTA,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jTA.setEditable(false);
        jTA.setBorder(BorderFactory.createTitledBorder("Order Detail"));
        wJLabel = new JLabel("");
        show = new JButton("Show");
        shop = new JButton("Shopping Again  ^_^");
        exit = new JButton("OK");

        scrollPane.setBounds(5,10,280,300);
        wJLabel.setBounds(30,310,140,20);
        show.setBounds(200,310,80,20);
        shop.setBounds(10,340,190,20);
        exit.setBounds(200,340,80,20);

        this.add(scrollPane);
        this.add(wJLabel);
        this.add(show);
        this.add(shop);
        this.add(exit);

        this.pack();
    }

    public void addExitListener(ActionListener listener){
        exit.addActionListener(listener);
    }

    public void addShopListener(ActionListener listener){
        shop.addActionListener(listener);
    }

    public void addShowListener(ActionListener listener){
        show.addActionListener(listener);
    }

    public void showDetail(String s){
        jTA.setText(s);
    }

    public void showCalculateTotalPrice(String s){
        wJLabel.setText(s);
    }

    public void close() {
        this.dispose();
    }
}

class ProductItemController {
    private ProductItemGUI productItemGUI;
    private ProductDB productDB;
    private CartItem cart;
    CustomApp parent;

    public ProductItemController(CustomApp parent, ProductItemGUI productItemGUI,ProductDB productDB,CartItem cart) {
        this.parent = parent;
        this.productItemGUI = productItemGUI;
        this.productDB = productDB;
        this.cart = cart;
        this.productItemGUI.addCheckoutListener(new CheckoutListener());
        this.productItemGUI.addListListener(new ListListener());
        this.productItemGUI.addAddListener(new AddListener());
        this.productItemGUI.addRemoveListener(new RemoveListener());
        this.productItemGUI.addClearListener(new ClearListener());
        this.productItemGUI.addExitListener(new ExitListener());
        this.productItemGUI.addConsoleListener(new ConsoleListener());
        addListElement();
    }

    public void addListElement(){
        for(Product p:productDB.productList)
            this.productItemGUI.addListElement(p.getProductName());
    }

    class CheckoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(cart.calculateTotalPrice() == 0){
                productItemGUI.setQStock("Cart is null...");
                productItemGUI.setPrice("");
            }else{
                CheckoutGUI checkoutGUI = new CheckoutGUI();
                CheckoutController checkoutController = new CheckoutController(parent, checkoutGUI,productDB,cart);
                productItemGUI.close();
                checkoutGUI.setVisible(true);
            }
        }
    }

    class ListListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            int s = 0;
            Product p = productDB.getProduct(productItemGUI.getListValue());
            s = p.getProductStock();

            if(s==0){
                productItemGUI.setQStock("Choose Product!!");
            }else{
                productItemGUI.setQStock("Stock : " + s);
            }
            productItemGUI.setPrice("Price : PLN" + p.getPrice());
        }
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Product p = productDB.getProduct(productItemGUI.getListValue());
            int s = p.getProductStock();
            int id=0;
            if(s!=0){
                if(s > productItemGUI.getCallNum()){
                    productDB.updateStock(p,productItemGUI.getCallNum());
                    int qty = productItemGUI.getCallNum();
                    id=cart.addProduct(p,qty);
                }else{
                    productDB.updateStock(p,s);
                    int qty = s;
                    id=cart.addProduct(p,qty);
                }
            }

            int ss = p.getProductStock();
            if(s<=0){
                productItemGUI.setQStock("Choose Product!!");
            }else{
                if (id<0){
                    productItemGUI.addRow(p);
                }else{
                    productItemGUI.setRow(id, p);
                }
                productItemGUI.setQStock("Stock : " + ss);
                productItemGUI.setPrice("Price : PLN" + p.getPrice());
                productItemGUI.setTotalPrice("Total Price: " + cart.calculateTotalPrice());
            }
        }
    }

    class RemoveListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            int r =-1;
            int c =-1;

            r = productItemGUI.getTableRow();
            c = productItemGUI.getTableColumn();
            if(r != -1 && c != -1){
                if( c == 1 || c == 0){
                    cart.removeProduct(productItemGUI.getTableRow());
                    Product p = productDB.getProduct(productItemGUI.getTableName(r));

                    int s = p.getProductStock();

                    if(productItemGUI.getListValue() == p.getProductName()){
                        productItemGUI.setQStock("Stock : " + s);
                    }

                    productItemGUI.setTotalPrice("Total Price: " + cart.calculateTotalPrice());
                    if(productItemGUI.getTableRow()==0){
                        productItemGUI.setTotalPrice("");
                    }
                }
                productItemGUI.defaultModelRemoveRow();
            }else{
                if(productItemGUI.getTableIsNull()){
                    productItemGUI.setQStock("");
                    productItemGUI.setPrice("");
                    productItemGUI.setTotalPrice("Cart is null...");
                }else{
                    productItemGUI.setTotalPrice("Select the items.");
                }
            }
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            cart.clearAll();
            productItemGUI.setTableNull();
            productItemGUI.setQStock("Choose Product!!");
            productItemGUI.setPrice("");
            productItemGUI.setTotalPrice("");
        }
    }
    class ExitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            productItemGUI.close();
            JOptionPane.showMessageDialog(null, "Thank you, we hope to see you next time.", "Msg", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    class ConsoleListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            parent.changeApp(new ConsoleApp());
            //new MainMenu();

            //JOptionPane.showMessageDialog(null, "Console shopping!!!", "Msg", JOptionPane.INFORMATION_MESSAGE );
        }
    }

}

class CheckoutController {
    private CheckoutGUI checkoutGUI;
    private CartItem cart;
    private ProductDB productDB;
    CustomApp parent;

    public CheckoutController(CustomApp parent, CheckoutGUI checkoutGUI,ProductDB productDB,CartItem cart){
        this.parent = parent;
        this.checkoutGUI = checkoutGUI;
        this.productDB = productDB;
        this.cart = cart;
        this.checkoutGUI.addExitListener(new ExitListener());
        this.checkoutGUI.addShopListener(new ShopListener());
        this.checkoutGUI.addShowListener(new ShowListener());

    }

    class ExitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            checkoutGUI.close();
            JOptionPane.showMessageDialog(null, "Happy shopping!", "Msg", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    class ShopListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            ProductItemGUI productItemGUI = new ProductItemGUI(parent);
            ProductItemController  productItemController = new ProductItemController(parent, productItemGUI,productDB,new CartItem());
            checkoutGUI.close();
            productItemGUI.setVisible(true);
        }
    }

    class ShowListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            checkoutGUI.showDetail(cart.getAllDetail());
            checkoutGUI.showCalculateTotalPrice("Total Price : PLN" + cart.calculateTotalPrice());
        }
    }
}


class ProductDB {
    ArrayList<Product> productList = new ArrayList<>();


    public ProductDB(){
        productList.add(new Product("iPhone",100,1000));
        productList.add(new Product("iPad",100,2500));
        productList.add(new Product("Microsoft Surface",100,2200));
        productList.add(new Product("Xbox",100,800));
        productList.add(new Product("Microsoft Lumia",100,600));
        productList.add(new Product("Lenovo Yoga",100,450));
        productList.add(new Product("Samsung Galaxy",100,500));
        productList.add(new Product("Sony Cyber-shot",100,200));
        productList.add(new Product("PlayStation",100,950));
        productList.add(new Product("Xperia",100,550));

    }

    public Product getProduct(String name) {
        Product a = new Product("",0,0);
        for(Product p :productList){
            if(name == p.getProductName()){
                return p;
            }
        }
        return a;
    }

    public void updateStock(Product p,int quantity){
        p.updateStock(quantity);
        for(Product pp : productList){
            if(p.getProductName() == pp.getProductName()){
                pp=p;
            }
        }
    }
}

class Product {
    private String name;
    private int stock;
    private int price;
    private int sell = 0;
    private int thissell;

    public Product(String name,int stock,int price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String getProductName(){
        return name;
    }

    public int getProductStock(){
        return stock;
    }

    public int getPrice(){
        return price;
    }

    public void setSell(int q){
        sell=q;
    }

    public int getSell(){
        return sell;
    }

    public int getThisSell(){
        return thissell;
    }

    public void updateStock(int quantity){
        stock -= quantity;
        thissell = quantity;
        sell+=quantity;
    }
    public int calculatePrice(){
        return sell*price;
    }
}

class Item{
    private Product product;
    private int qty=0;
    public Item(Product product){
        this.product=product;
    }
    public void remove(){
        product.updateStock(qty*(-1));
    }
    public void addqty(int q){
        qty+=q;
    }
    public Product getProduc(){
        return product;
    }
    public int getsellqty(){
        return qty;
    }
}

class CartItem {
    ArrayList<Item> cItem = new ArrayList<>();

    Random ran = new Random();
    int no = ran.nextInt(1000) + 1;
    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    Date date = new Date();
    String strDate = "Date: " + sdFormat.format(date);

    public void setCartNull() {
        cItem = null;
    }

    public int addProduct(Product p, int qty) {
        System.out.println(p.getProductName());
        Item newitem = null;
        int id = -1;
        int rid = -1;
        for (Item i : cItem) {
            id++;
            if (i.getProduc() == p) {
                rid = id;
                newitem = i;
                break;
            }
        }

        if (newitem == null) {
            rid = -1;
            newitem = new Item(p);
            cItem.add(newitem);
        }
        newitem.addqty(qty);
        System.out.println("ID: " + id);
        p.setSell(newitem.getsellqty());
        System.out.println("cItem number: " + cItem.size());
        System.out.println("this sell: " + newitem.getProduc().getSell());
        System.out.println(calculateTotalPrice());
        return rid;
    }

    public void removeProduct(int id) {
        Item i = cItem.get(id);
        i.remove();
        i = null;
        cItem.remove(id);
    }

    public void clearAll() {
        for (Item i : cItem) {
            i.remove();
            i = null;
        }
        cItem.removeAll(cItem);
    }

    public int calculateTotalPrice() {
        int all = 0;
        for (Item p : cItem) {
            all += p.getProduc().calculatePrice();
        }
        return all;
    }

    public String getAllDetail() {
        String str = "";

        for (Item i : cItem) {
            Product p = i.getProduc();
            System.out.println(p);
            String a = p.getProductName();
            String b = String.valueOf(i.getsellqty());
            String c = String.valueOf(p.getPrice());
            System.out.println(a + " " + b + " " + c);
            str += "Product: " + a + "/ Quantity: " + b + "/ Price: " + c;
            //return a+" "+b+" "+c;
            str += "\n";
        }
        str = "NO." + no + "\n" + strDate + "\n" + str;
        return str;
    }

}