package mainpackage;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class gameController {

    @FXML private GridPane sudokuGridPane;
    @FXML Label counter;

    boolean labelAreInitialized=false;
    boolean wrongValue=false;

    Label LastselctedLabel = null;
    Label SelectedLabel = null;

    public static int value=0;
    int count=0;
    public int level=1;

    //startRound

    //Position position = getRowCol(label.getId());
    //int valuePuzzleBoardAtIndex = Main.puzzleBoard.getNumberAtIdx(position.row, position.col);

    /**
     * Method is setting labels when startGame button is clicked
     */

    private void setLabels(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //every label is getting a value of 0
                Label label = new Label("0");
                label.setVisible(true);
                label.setId("Label_" + i + "_" + j);
                label.setAlignment(Pos.CENTER);
                //position
                label.setPrefHeight(44.0);
                label.setPrefWidth(46.0);
                //Mouse clicked wird hier implizit implementiert um das selektierte Label zu
                //markieren.
                label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Label label = (Label) event.getSource();
                        SelectedLabel = label;

                        if(LastselctedLabel!=null)
                            LastselctedLabel.setBackground(null);

                        LastselctedLabel = label;

                        Background bg = new Background(new BackgroundFill(Color.CADETBLUE, null, null));
                        label.setBackground(bg);
                    }
                });
                //GridPane.columnIndex="8" GridPane.rowIndex="8"
                if(sudokuGridPane!=null) {
                    sudokuGridPane.add(label, i, j);
                }
            }

        }
    }

    /**
     * new class to enable input of labelId and output of col & row in method getRowCol
     */
    public class Position
    {
        public int row=0;
        public int col=0;
    }

    private Position getRowCol(String labelId) {
        char rowchar = labelId.charAt(6);
        char colchar = labelId.charAt(8);

        Position position=new Position();

        position.row = Integer.parseInt(String.valueOf(rowchar));
        position.col = Integer.parseInt(String.valueOf(colchar));

        return position;
    }

    /**
     * Method to load new sudoku in labels
     */
    public void startRound(){

        while (!Main.gameFinished) {

            int size = sudokuGridPane.getChildren().size();
            Label label=null;
            if(sudokuGridPane!=null && size>0) {
                //for each Schleife um jedes Label zu testen
                for (Node node : sudokuGridPane.getChildren()) {
                    try {
                        //to make sure that node is a label
                        //if it is label stays a node
                        label = (Label) node;
                    }
                    catch(Exception e)
                        {
                            System.out.println("Exception. Node not a Label");
                        }

                    if(label!=null) {
                        Position position = getRowCol(node.getId());
                        int valuePuzzleBoardAtIndex = Main.puzzleBoard.getNumberAtIdx(position.row, position.col);
                        //to create labels that can be changed by user input
                        if(valuePuzzleBoardAtIndex==0) {
                            label.setText(Integer.toString(valuePuzzleBoardAtIndex));
                        }else{
                            //given numbers can't be changed
                            label.setText(Integer.toString(valuePuzzleBoardAtIndex));
                            label.setDisable(true);
                        }
                    }
                }
            }
            break;
        }
        //board.checkWinning();
    }
    /*
    public void startRound2(){

        //create Label for wrong input counter

        while (!Main.gameFinished) {

            int size = sudokuGridPane.getChildren().size();
            Label label=null;
            if(sudokuGridPane!=null && size>0) {
                //for each Schleife um jedes Label zu testen
                for (Node node : sudokuGridPane.getChildren()) {
                    try {
                        //to make sure that node is a label
                        //if it is label stays a node
                        label = (Label) node;
                    }
                    catch(Exception e)
                    {
                        System.out.println("Exception. Node not a Label");
                    }
                    if(label!=null) {
                        Position position = getRowCol(node.getId());
                        int valuePuzzleBoardAtIndex = Main.puzzleBoard2.getNumberAtIdx(position.row, position.col);
                        //to create labels that can be changed by user input
                        if(valuePuzzleBoardAtIndex==0) {
                            label.setText(Integer.toString(valuePuzzleBoardAtIndex));
                        }else{
                            //given numbers can't be changed
                            label.setText(Integer.toString(valuePuzzleBoardAtIndex));
                            label.setDisable(true);
                        }
                    }
                }
            }
            break;
        }
        //board.checkWinning();
    }
    */

    /**
     * This method compares the input with the solutionBoard
     * If input is valse, the label turns red and counts one mistake
     * @param value
     * @return boolean
     */

    public boolean checkInput(int value){
        String id = SelectedLabel.getId();
        char rowchar=id.charAt(6);
        char colchar=id.charAt(8);
        int row= Integer.parseInt( String.valueOf(rowchar) );
        int col= Integer.parseInt( String.valueOf(colchar) );
        int valueSolved=Main.solutionBoard.getNumberAtIdx(row,col);
        if(value==valueSolved){
            Background bg = new Background(new BackgroundFill(Color.WHITE, null, null));
            SelectedLabel.setBackground(bg);
            System.out.println("true");
            return true;
        }
        System.out.println("false");
        wrongInput();
        wrongValue=true;
        if(count<3){
            count++;
            counter.setText("Wrong input counter: "+count+"/3");
                             // <Label prefHeight="41.0" prefWidth="141.0" text="Wrong input counter: 0/3" GridPane.columnIndex="1" GridPane.rowIndex="1" />
        } else{
            display();
        }
        return false;
    }

    //to show a new window

    public void display() {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setMinWidth(300);
        window.setMaxHeight(250);

        Label label1 = new Label();
        label1.setText("You lost");
        Label label2 = new Label();
        label2.setText("");
        Button backButton=new Button("Home");
        //EventHandler<ActionEvent> actionEventEventHandler = goBackPressed(event);
        //backButton.setOnAction(actionEventEventHandler);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1);
        layout.getChildren().add(backButton);
        layout.getChildren().addAll(label2);
        layout.setAlignment(Pos.CENTER);

        Scene scene =new Scene(layout);
        window.setScene(scene);
        window.show();

    }

    @FXML
    protected void goBackHome(ActionEvent event) {

        URL fxmlFileUrl = getClass().getClassLoader().getResource("startgame.fxml");
        try {
            Parent root = FXMLLoader.load(fxmlFileUrl);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Method to enable start playing
     * @param event
     */

    @FXML
    public void OnStartGameClicked(MouseEvent event) {
        if(!labelAreInitialized) {
            this.setLabels();
            labelAreInitialized = true;
            //level=1;
            //getLevel(level);
            //level = 1;
        }
        startRound();
    }

    @FXML
    protected void OnStartGameClickedlevel2(MouseEvent event) {
        if(!labelAreInitialized) {
            this.setLabels();
            labelAreInitialized = true;
            //level=2;
            //getLevel(level);
        }
        startRound();
    }

    @FXML
    public void goBackPressed(ActionEvent event) {
        URL fxmlFileUrl = getClass().getClassLoader().getResource("home.fxml");
        try {
            Parent root = FXMLLoader.load(fxmlFileUrl);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void level1pressed(ActionEvent event){

        URL fxmlFileUrl = getClass().getClassLoader().getResource("game1.fxml");

        try {
            Parent root = FXMLLoader.load(fxmlFileUrl);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        level=1;
        setLevel(level);
    }
    @FXML
    protected void level2pressed(ActionEvent event){
        URL fxmlFileUrl = getClass().getClassLoader().getResource("game2.fxml");
        try {
            Parent root = FXMLLoader.load(fxmlFileUrl);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        level=2;
        setLevel(level);
    }
    @FXML
    protected void level3pressed(ActionEvent event) {
        URL fxmlFileUrl = getClass().getClassLoader().getResource("game3.fxml");
        try {
            Parent root = FXMLLoader.load(fxmlFileUrl);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Buttons for input 1 to 9
     */

    @FXML
    protected void auswahl1() {
        this.value=1;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("1");
        checkInput(value);
    }
    @FXML
    protected void auswahl2() {
        this.value=2;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("2");
        checkInput(value);
    }
    @FXML
    protected void auswahl3() {
        this.value=3;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("3");
        checkInput(value);
    }
    @FXML
    protected void auswahl4() {
        this.value=4;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("4");
        checkInput(value);
    }
    @FXML
    protected void auswahl5() {
        this.value=5;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("5");
        checkInput(value);
    }
    @FXML
    protected void auswahl6() {
        this.value=6;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("6");
        checkInput(value);
    }
    @FXML
    protected void auswahl7() {
        this.value=7;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("7");
        checkInput(value);
    }
    @FXML
    protected void auswahl8() {
        this.value=8;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("8");
        checkInput(value);
    }
    @FXML
    protected void auswahl9() {
        this.value=9;
        setValue(value);
        if(this.SelectedLabel!=null)
            this.SelectedLabel.setText("9");
        checkInput(value);
    }

    //delete last input
    @FXML
    protected void backPressed(){
        Background bg = new Background(new BackgroundFill(Color.WHITE, null, null));
        SelectedLabel.setBackground(bg);
        SelectedLabel.setText("0");
    }

    //für falschen Input rotes Feld
    @FXML
    private void wrongInput() {
        Background bg = new Background(new BackgroundFill(Color.PINK, null, null));
        SelectedLabel.setBackground(bg);
    }


    public void setValue(int value) {
       this.value=value;
    }

    public int setLevel(int level) {
        return level;
    }

    public int getLevel() {
        return level;
    }
}
