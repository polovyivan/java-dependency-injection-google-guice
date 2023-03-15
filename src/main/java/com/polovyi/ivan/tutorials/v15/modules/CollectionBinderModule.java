package com.polovyi.ivan.tutorials.v15.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.name.Names;
import com.polovyi.ivan.tutorials.v15.CSVReportGenerator;
import com.polovyi.ivan.tutorials.v15.ReportGenerator;
import com.polovyi.ivan.tutorials.v15.ReportGenerator.ReportType;
import com.polovyi.ivan.tutorials.v15.XMLReportGenerator;

public class CollectionBinderModule extends AbstractModule {

    @Override
    protected void configure() {
        MapBinder<ReportType, ReportGenerator> reportGeneratorBinder =
                MapBinder.newMapBinder(binder(), ReportType.class, ReportGenerator.class);

        reportGeneratorBinder.addBinding(ReportType.CSV).to(CSVReportGenerator.class);
        reportGeneratorBinder.addBinding(ReportType.XML).to(XMLReportGenerator.class);
    }
}
