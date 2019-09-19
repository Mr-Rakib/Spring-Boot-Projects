package bd.seu.ac.vaadindemorakib.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route(value = "")
public class MainView extends VerticalLayout {
    public MainView() {

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        TextField number1 = new TextField("Number 1","Enter a number");
        TextField number2 = new TextField("Number 2","Enter a number");
        TextField result = new TextField("Result","Result will show here");


        Button addButton = new Button("Add");


        addButton.addClickListener(event ->{

            int num1 =Integer.parseInt(number1.getValue());
            int num2 =Integer.parseInt(number2.getValue());
            int res = num1 + num2;
            result.setValue(""+res);

        });
        horizontalLayout.add(number1,number2,addButton,result);
        add(horizontalLayout);



        Button button = new Button("Click Me");
        button.setText("Click me");
        button.addClickListener(event -> Notification.show("Hello World!") );

        add(button);

    }


}
