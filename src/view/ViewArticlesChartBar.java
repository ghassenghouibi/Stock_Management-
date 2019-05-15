package view;

import javax.swing.*;
import java.awt.event.*;

import java.awt.Color;

import controller.BarChart;

public class ViewArticlesChartBar implements ActionListener {

    private JFrame frame;

    private JMenuBar menuBar;
    private JMenu    file;
    private JMenuItem open;
    private JMenuItem print;
    private JMenuItem saveAs;
    private JMenuItem close;

    private JMenu     home;
    private JMenuItem homeView;
    private JMenuItem addCashier;
    private JMenuItem checkDocument;
    private JMenuItem checkAlert;
    
    private JMenu     article;
    private JMenuItem articleViewChartBar;
    private JMenuItem articleViewTable;

    private JMenu     provider;
    private JMenuItem providerView;

    public ViewArticlesChartBar(JFrame frame){
        createGUI(frame);
    }

    public void createGUI(JFrame myFrame){

        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().repaint();    
         

        BarChart chart = new BarChart();
        chart.addBar(Color.red, 100);
        chart.addBar(Color.green, 8);
        chart.addBar(Color.blue, 54);
        chart.addBar(Color.white, 60);
        chart.addBar(Color.yellow, 24);
        chart.addBar(Color.cyan, 70);
        chart.addBar(Color.gray, 6);
        chart.addBar(Color.lightGray, 77);
        chart.addBar(Color.magenta, 90);
        chart.addBar(Color.pink, 12);
        chart.addBar(Color.orange, 65);

        myFrame.getContentPane().add(chart);
        myFrame.pack();
        myFrame.setSize(800,620);
        myFrame.setVisible(true);

        frame=myFrame;

        myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});

    }

    public void createMenu(JFrame myFrame){
        menuBar=new JMenuBar();

        //file
        file=new JMenu("file");
        open=new JMenuItem("open");
        print=new JMenuItem("print");
        saveAs=new JMenuItem("save as");
        close=new JMenuItem("close");
        file.add(open);
        file.add(print);
        file.add(saveAs);
        file.add(close);


        //home
        home=new JMenu("home");
        homeView=new JMenuItem("home view");
        addCashier=new JMenuItem("add cashier");
        checkDocument=new JMenuItem("check document");
        checkAlert=new JMenuItem("check alert");
        homeView.addActionListener(this);
        addCashier.addActionListener(this);
        checkDocument.addActionListener(this);
        checkAlert.addActionListener(this);

        home.add(homeView);
        home.add(addCashier);
        home.add(checkDocument);
        home.add(checkAlert);

        //Article
        article=new JMenu("article");
        articleViewChartBar=new JMenuItem("article view chartBar");
        articleViewTable=new JMenuItem("article view table ");
        articleViewChartBar.addActionListener(this);
        articleViewTable.addActionListener(this);
        article.add(articleViewChartBar);
        article.add(articleViewTable);
          
        provider=new JMenu("provider");
        providerView=new JMenuItem("provider view");
        providerView.addActionListener(this);
        provider.add(providerView);


        menuBar.add(file);
        menuBar.add(home);
        menuBar.add(article);
        menuBar.add(provider);

        myFrame.setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==homeView){
            new ViewRetailer(frame);
        }
        if (source==providerView){
            new ViewProvider(frame);
        }
        if (source==articleViewTable){
            new ViewArticlesTable(frame);
        }
        if (source==articleViewChartBar){
            new ViewArticlesChartBar(frame);
        }
        if (source==checkAlert || source==checkDocument){
            //TODO send mail
        }
        if(source==addCashier){
            //TODO add cashier
        }
    }
}