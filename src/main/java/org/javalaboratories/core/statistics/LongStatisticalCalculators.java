package org.javalaboratories.core.statistics;

public class LongStatisticalCalculators extends ComprehensiveStatisticalCalculators<Long> {

    public LongStatisticalCalculators() {
        super(new LongSummaryStatisticsAdapter());
    }
}
