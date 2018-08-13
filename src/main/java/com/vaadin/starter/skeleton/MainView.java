package com.vaadin.starter.skeleton;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.ListSeries;
import com.vaadin.flow.component.charts.model.Tooltip;
import com.vaadin.flow.component.charts.model.XAxis;
import com.vaadin.flow.component.charts.model.YAxis;
import com.vaadin.flow.component.charts.model.style.SolidColor;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.Route;

import java.util.Random;
import java.util.stream.IntStream;

@Route("")
@BodySize(height = "100vh", width = "100vw")
@HtmlImport("styles/shared-styles.html")
public class MainView extends VerticalLayout {

    private Random random = new Random();

    public MainView() {
        Chart chart = createNewChart();
        chart.addChartClickListener(e -> {
            // Select a random series and set it to a random color
            // by setting a CSS variable and let the browser do the coloring
            int seriesIndex = random.nextInt(5);

            getElement().getStyle().set("--vaadin-charts-color-" + seriesIndex, randomColor());
        });

        add(chart);
    }

    private Chart createNewChart() {
        Chart chart = new Chart();

        Configuration configuration = chart.getConfiguration();
        configuration.setTitle("Click on the Chart as much as you like :)");

        IntStream.range(0, 5).forEach(e -> configuration.addSeries(new ListSeries(randomValues())));

        Tooltip tooltip = new Tooltip();
        tooltip.setEnabled(false);
        configuration.setTooltip(tooltip);

        return chart;
    }

    private Number[] randomValues() {
        return IntStream.generate(() -> 1 + random.nextInt(10)).boxed().limit(10).toArray(Number[]::new);
    }

    private String randomColor() {
        return new SolidColor(random.nextInt(256), random.nextInt(256), random.nextInt(256)).toString();
    }
}
