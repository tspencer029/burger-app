package user;

import java.io.StringWriter;

import javafx.application.Application;
import javafx.beans.value.WritableBooleanValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI extends Application {
    Stage window;
    Scene scene;
    Button button;
    
    public static void main(String[] args) {
        launch(args);
    }
    
@Override
public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("Vahid's Burgers");
    
    Group root = new Group();
    Insets ingInsets = new Insets(10,20,10,20);
    VBox ingredientList = new VBox(10);
    double finalPrice = 0.00;
    String priceString = ("$" + finalPrice);
    Label price = new Label(priceString);
    price.setLayoutY(360);
    price.setLayoutX(50);
    String css = "-fx-border-color: black;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 3;\n" +
            "-fx-border-style: solid;\n";
    
    //Arrays
    CheckBox [] bunArray = new CheckBox [4];
    CheckBox [] pattyArray = new CheckBox [3]; //needed to prevent users from adding too many ingredients
    CheckBox [] cheeseArray = new CheckBox [3];
    CheckBox [] toppingArray = new CheckBox [3];
    CheckBox [] sauceArray = new CheckBox [4];
    
    //Login Gridpane
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10,10,10,10));
    grid.setVgap(8);
    grid.setHgap(8);
    
    //BunCheckBox
    Text bunHeader = new Text("Bun:");
    double bunPrice = 1.00;
    CheckBox bunBox = new CheckBox("Wheat Bun");
    CheckBox bunBox1 = new CheckBox("Garlic Bread Bun");
    CheckBox bunBox2 = new CheckBox("Italian Herb Bread");
    CheckBox bunBox3 = new CheckBox("Sesame");
    bunArray[0] = bunBox;
    bunArray[1] = bunBox1;
    bunArray[2] = bunBox2;
    bunArray[3] = bunBox3;
    
    //PattyCheckBox
    Text pattyHeader = new Text("Patty:");
    CheckBox box1 = new CheckBox("Beef Patty");
    CheckBox box2 = new CheckBox("Pork Patty");
    double meatPattyPrice = 1.50;
    CheckBox box3 = new CheckBox("Vegetarian Patty");
    double vegPattyPrice = 2.00;
    pattyArray[0]=box1;
    pattyArray[1]=box2;
    pattyArray[2]=box3;
    
    //CheeseCheckBox
    Text cheeseHeader = new Text("Cheese:           (Limit 2)");
    CheckBox box4 =new CheckBox("Stinky Cheese");
    CheckBox box5 =new CheckBox("Old Cheese");
    double cheesePrice = 0.50;
    CheckBox box6 =new CheckBox("Weird looking Cheese");
    double weirdCheesePrice = 0.75;
    cheeseArray[0]=box4;
    cheeseArray[1]=box5;
    cheeseArray[2]=box6;
    
    //ToppingsCheckBox
    Text toppingHeader = new Text("Toppings:");
    CheckBox box11 = new CheckBox("Bacon");
    double baconPrice = 1.00;
    CheckBox box12 = new CheckBox("Peppers");
    double pepperPrice = 0.70;
    CheckBox box13 = new CheckBox("Avocado");
    double avoPrice = 10.0;
    toppingArray[0] = box11;
    toppingArray[1] = box12;
    toppingArray[2] = box13;
    
    //SauceCheckBox (Limit 2)
    Text sauceHeader = new Text("Sauce:             (Limit 2)");
    CheckBox box7 =new CheckBox("Mayo");
    CheckBox box8 =new CheckBox("Tomato Sauce");
    CheckBox box9 =new CheckBox("BBQ sauce");
    CheckBox box10 =new CheckBox("Wasabi");
    double saucePrice = 0.20;
    double wasabiPrice = 0.30;
    sauceArray[0]=box7;
    sauceArray[1]=box8;
    sauceArray[2]=box9;
    sauceArray[3]=box10;
    
    //ToppingsCheckBox
    
    //Bun limiter
    for (int i = 0 ; i < bunArray.length;i++)
        bunArray[i].selectedProperty().addListener( (o, oldV, newV) -> {
            if(newV) {
                int sel = 0;
                for(CheckBox cb : bunArray)
                    if(cb.isSelected())
                        sel++;
                ((WritableBooleanValue) o).set(sel <= 1);
            }
        });
    
    //Patty limiter
    for (int i = 0 ; i < pattyArray.length;i++)
        pattyArray[i].selectedProperty().addListener( (o, oldV, newV) -> {
            if(newV) {
                int sel = 0;
                for(CheckBox cb : pattyArray)
                    if(cb.isSelected())
                        sel++;
                ((WritableBooleanValue) o).set(sel <= 2);
            }
        });
    //Cheese limiter
    for (int i = 0 ; i < cheeseArray.length;i++)
        cheeseArray[i].selectedProperty().addListener( (o, oldV, newV) -> {
            if(newV) {
                int sel = 0;
                for(CheckBox cb : cheeseArray)
                    if(cb.isSelected())
                        sel++;
                ((WritableBooleanValue) o).set(sel <= 2);
            }
        });
    //Sauce 
    for (int i = 0 ; i < sauceArray.length;i++)
        sauceArray[i].selectedProperty().addListener( (o, oldV, newV) -> {
            if(newV) {
                int sel = 0;
                for(CheckBox cb : sauceArray)
                    if(cb.isSelected())
                        sel++;
                ((WritableBooleanValue) o).set(sel <= 2);
            }
        });
    //Username Label
    Label nameLabel = new Label("Name:");
    GridPane.setConstraints(nameLabel, 0, 0);
    
//    //Password Label
//    Label passLabel = new Label("Password:");
//    GridPane.setConstraints(passLabel, 0, 1);
    
    //Username input
    TextField usernameInput = new TextField();
    GridPane.setConstraints(usernameInput,1,0);
    
//    //Password input
//    PasswordField passInput = new PasswordField();
//    GridPane.setConstraints(passInput,1,1);
    
    //Scrollpanes
    ScrollPane sp = new ScrollPane();
    sp.setPannable(true);
    sp.setPrefSize(200, 250);
    sp.setContent(ingredientList);
    sp.setLayoutY(100);
    sp.setLayoutX(50);
    
    ScrollPane confirmBox = new ScrollPane();
    confirmBox.setLayoutX(300);
    confirmBox.setLayoutY(200);
    confirmBox.setPrefSize(150, 150);
    Text text = new Text("       ");
    confirmBox.setContent(text);

    //Buttons
    Button orderButton = new Button("Order");
    orderButton.setOnAction(e ->handleOptions(price, finalPrice, bunBox,bunBox1,bunBox2,bunBox3,box1,box2,box3,
    		box4,box5,box6,box7,box8,box9,box10,box11,box12,box13, bunPrice, meatPattyPrice, 
    		text, vegPattyPrice, cheesePrice, weirdCheesePrice, baconPrice, pepperPrice, avoPrice, 
    		saucePrice, wasabiPrice));
    orderButton.setLayoutY(360);
    orderButton.setLayoutX(200);
    
    Button confirmButton = new Button("Confirm");
    confirmButton.setOnAction(e -> handleConfirm());
    confirmButton.setLayoutY(360);
    confirmButton.setLayoutX(392);
    
    
//    Button loginButton = new Button("Log in");
//    GridPane.setConstraints(loginButton,1,2);
    Button regButton = new Button("Register");
    GridPane.setConstraints(regButton,1,1);
    
    //Layout
    ingredientList.setPadding(ingInsets);
    ingredientList.getChildren().addAll(bunHeader);
    ingredientList.getChildren().addAll(bunArray);
    ingredientList.getChildren().addAll(pattyHeader);
    ingredientList.getChildren().addAll(pattyArray);
    ingredientList.getChildren().addAll(cheeseHeader);
    ingredientList.getChildren().addAll(cheeseArray);
    ingredientList.getChildren().addAll(toppingHeader);
    ingredientList.getChildren().addAll(toppingArray);
    ingredientList.getChildren().addAll(sauceHeader);
    ingredientList.getChildren().addAll(sauceArray);
    grid.getChildren().addAll(nameLabel, usernameInput,regButton);
    
    final ImageView burgerImage = new ImageView();   
    Image image1 = new Image(getClass().getResourceAsStream("Burgertrans.png"));
    Image image2 = new Image(getClass().getResourceAsStream("Hexagon-3.jpg"));
    burgerImage.setImage(image1);
    burgerImage.setLayoutX(350);
    burgerImage.setLayoutY(20);
    burgerImage.setFitHeight(100);
    burgerImage.setFitWidth(100);
    
    //Group
    root.getChildren().addAll(grid,confirmBox,sp,orderButton,price,confirmButton,burgerImage);
    
    scene = new Scene(root, 500,450);
    scene.setFill(new ImagePattern(image2));
    window.setScene(scene);
    window.show();
    
}

private void handleConfirm() {
	StringWriter sw = new StringWriter();
	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setHeaderText("Order complete \n Your burger(s) will be ready shortly");
	        alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(sw.toString())));
	        alert.showAndWait();
}

//Handle check box options
private void handleOptions(Label price, double finalPrice, CheckBox bunBox, CheckBox bunBox1, CheckBox bunBox2, CheckBox bunBox3,
		CheckBox box1,CheckBox box2,CheckBox box3,CheckBox box4,CheckBox box5,CheckBox box6,
		CheckBox box7, CheckBox box8, CheckBox box9, CheckBox box10, CheckBox box11,
		CheckBox box12, CheckBox box13, double bunPrice, double meatPattyPrice, Text text, 
		double vegPattyPrice, double cheesePrice, double weirdCheesePrice, double baconPrice,
		double pepperPrice, double avocadoPrice, double saucePrice, double wasabiPrice){
    
	String message ="Burger:\n";
    if(bunBox.isSelected()){
        message += "Wheat Bun \n";
        finalPrice += bunPrice;
        price.setText("$" + finalPrice);
    }
    if(bunBox1.isSelected()){
        message += "Garlic Bread Bun \n";
        finalPrice += bunPrice;
        price.setText("$" + finalPrice);
    }
    if(bunBox2.isSelected()){
        message += "Italian Herb Bun \n";
        finalPrice += bunPrice;
        price.setText("$" + finalPrice);
    }
    if(bunBox3.isSelected()){
        message += "Sesame Bun \n";
        finalPrice += bunPrice;
        price.setText("$" + finalPrice);
    }
    if(box1.isSelected()){
        message += "Beef patty \n";
        finalPrice += meatPattyPrice;
        price.setText("$" + finalPrice);
    }
    if(box2.isSelected()){
        message += "Pork patty \n";
        finalPrice += meatPattyPrice;
        price.setText("$" + finalPrice);
    }
    if(box3.isSelected()){
        message += "Vegetarian patty \n";
        finalPrice += vegPattyPrice;
        price.setText("$" + finalPrice);
    }
    if(box4.isSelected()){
        message += "Stinky Cheese \n";
        finalPrice += cheesePrice;
        price.setText("$" + finalPrice);
    }
    if(box5.isSelected()){
        message += "Old Cheese \n";
        finalPrice += cheesePrice;
        price.setText("$" + finalPrice);
    }
    if(box6.isSelected()){
        message += "Weird looking cheese \n";
        finalPrice += weirdCheesePrice;
        price.setText("$" + finalPrice);
    }
    if(box11.isSelected()){
        message += "Bacon \n";
        finalPrice += baconPrice;
        price.setText("$" + finalPrice);
    }
    if(box12.isSelected()){
        message += "Peppers \n";
        finalPrice += pepperPrice;
        price.setText("$" + finalPrice);
    }
    if(box13.isSelected()){
        message += "Avocado \n";
        finalPrice += avocadoPrice;
        price.setText("$" + finalPrice);
    }
    if(box7.isSelected()){
        message += "Mayo \n";
        finalPrice += saucePrice;
        price.setText("$" + finalPrice);
    }
    if(box8.isSelected()){
        message += "Tomato sauce \n";
        finalPrice += saucePrice;
        price.setText("$" + finalPrice);
    }
    if(box9.isSelected()){
        message += "BBQ sauce \n";
        finalPrice += saucePrice;
        price.setText("$" + finalPrice);
    }
    if(box10.isSelected()){
        message += "Wasabi \n";
        finalPrice += wasabiPrice;
        price.setText("$" + finalPrice);
    }
    text.setText(message + "-------");
    box1.setSelected(false);
    box2.setSelected(false);
    box3.setSelected(false);
    box4.setSelected(false);
    box5.setSelected(false);
    box6.setSelected(false);
    box7.setSelected(false);
    box8.setSelected(false);
    box9.setSelected(false);
    box10.setSelected(false);
    box11.setSelected(false);
    box11.setSelected(false);
    box12.setSelected(false);
    box13.setSelected(false);
    bunBox.setSelected(false);
    bunBox1.setSelected(false);
    bunBox2.setSelected(false);
    bunBox3.setSelected(false);
    System.out.println(message);
}
}