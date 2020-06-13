import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    List<String> history;
    int curPos;
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curPos=0;
    }

    public void visit(String url) {
        if(history.size()!=curPos+1) {
            for(int i=history.size()-1;i>curPos;i--) {
                history.remove(i);
            }
        }
        history.add(url);
        curPos++;
    }

    public String back(int steps) {
        curPos = Math.max((curPos - steps), 0);
        return history.get(curPos);
    }

    public String forward(int steps) {
        curPos = Math.min(history.size() - 1, (curPos + steps));
        return history.get(curPos);
    }

    public static void main(String args[]) {
        BrowserHistory browserHistory = new BrowserHistory("jrblit");
        System.out.println("null");
        System.out.println("null");
        browserHistory.visit("uiza");
        System.out.println(browserHistory.forward(3));
        System.out.println(browserHistory.forward(3));
        System.out.println("null");
        browserHistory.visit("feryl");
        System.out.println("null");
        browserHistory.visit("hyhq");
        System.out.println(browserHistory.back(3));
        System.out.println("null");
        browserHistory.visit("css");
        System.out.println("null");
        browserHistory.visit("biz");
        System.out.println(browserHistory.forward(6));
        System.out.println(browserHistory.back(1));
        System.out.println("null");
        browserHistory.visit("cmb.com");
        //[null,null,"uiza.com","uiza.com",null,null,"jrbilt.com",null,null,"bivz.com","cccs.com"
    }
}