package com.bulldozer.reports;

import java.util.List;

public interface Reportable {
    List<ReportItem> generateReport();
}
