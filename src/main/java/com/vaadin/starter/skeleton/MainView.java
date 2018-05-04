package com.vaadin.starter.skeleton;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.ListSeries;
import com.vaadin.flow.component.charts.model.XAxis;
import com.vaadin.flow.component.charts.model.YAxis;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a template element.
 */
@HtmlImport("styles/shared-styles.html")
@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        ThinContainer thinContainer = new ThinContainer();
        CustomContainer customContainer1 = new CustomContainer();
        customContainer1.getElement().appendChild(createNewChart().getElement());
        thinContainer.getElement().appendChild(customContainer1.getElement());

        ThickContainer thickContainer = new ThickContainer();
        CustomContainer customContainer2 = new CustomContainer();
        customContainer2.getElement().appendChild(createNewChart().getElement());
        thickContainer.getElement().appendChild(customContainer2.getElement());

        add(thinContainer, thickContainer);
    }

    private Chart createNewChart() {
        Chart chart = new Chart();

        Configuration configuration = chart.getConfiguration();
        configuration.setTitle("Example Column Chart");

        configuration.addSeries(new ListSeries("Tokyo", 20, 12, 34, 23, 65, 8, 4, 7, 76, 19, 20, 8));

        XAxis x = new XAxis();
        x.setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec");
        configuration.addxAxis(x);

        YAxis y = new YAxis();
        y.setMin(0);
        y.setTitle("Rainfall (mm)");
        configuration.addyAxis(y);

        return chart;
    }
}
