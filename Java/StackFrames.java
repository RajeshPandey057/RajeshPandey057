
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import mypackage.*;
public class Assignment extends Applet implements ActionListener
{
    Button done,push,pop,vs;
    TextField t1;
    Label l1;
    int n,tos=-1,a[];
    public void init()
    {
        this.setLayout( new FlowLayout(FlowLayout.LEFT, 35, 30) );
        l1=new Label("Enter Size of Stack:");
        t1=new TextField(40);
        done=new Button("DONE");
        push=new Button("PUSH");
        pop=new Button("POP");
        vs=new Button("VIEW STACK");
        add(l1);
        add(t1);
        add(done);
        add(push);
        add(pop);
        add(vs);
        vs.setVisible(false);
        push.setVisible(false);
        pop.setVisible(false);
        done.addActionListener(this);
        push.addActionListener(this);
        pop.addActionListener(this);
        vs.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String temp=ae.getActionCommand();
        if(temp.equals("DONE"))
        {
            n=Integer.parseInt(t1.getText());
            a=new int[n];
            done.setVisible(false);
            push.setVisible(true);
            pop.setVisible(true);
            vs.setVisible(true);
            l1.setText("Start Your Operations:");
        }
        else if(temp.equals("PUSH"))
        {
            try
            {
                String s1=t1.getText();
                if(s1.equals("")) throw new StringIndexOutOfBoundsException();
                int value = Integer.parseInt(s1);
                t1.setText("");
                if(tos==n) throw new ArrayIndexOutOfBoundsException();
                a[++tos] = value;
                l1.setText(value + " is Pushed in stack");
            }
            catch (ArrayIndexOutOfBoundsException ai)
            {
                l1.setText("Stack is Overflowed....!");
                tos--;
            }
            catch (StringIndexOutOfBoundsException sb)
            {
                l1.setText("Please Enter something to push....");
            }
            catch (NumberFormatException ne)
            {
                l1.setText("Push numbers only");
            }
        }
        else if(temp.equals("POP"))
        {
            try
            {
                if(tos<0) throw new StackOverflowError();
                int value = a[tos];
                tos--;
                t1.setText("");
                l1.setText(value + " is Poped out of stack");
            }
            catch (StackOverflowError ai)
            {
                l1.setText("Stack is Underflowed... :(");
            }
        }
        else if(temp.equals("VIEW STACK"))
        {
           stackframe s=new stackframe(a,n,tos);
        }
    }
}
 
