package com.tdna.testtask.repository;

import com.tdna.testtask.domain.ResultParameter;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class ResultProcessor {

    public static final int TOP_RESULTS_COUNT = 20;

    public void processAddResult(Map<Long, CopyOnWriteArraySet<ResultParameter>> results, ResultParameter newResult) {
        if (!results.containsKey(newResult.getKeyParameter())) {
            addNewResultEntry(results, newResult);
            return;
        }

        CopyOnWriteArraySet<ResultParameter> topResults = results.get(newResult.getKeyParameter());

        if (topResults.size() < TOP_RESULTS_COUNT) {
            topResults.add(newResult);
        } else {
            tryToAddNewResult(topResults, newResult);
        }
    }

    private void addNewResultEntry(Map<Long, CopyOnWriteArraySet<ResultParameter>> results, ResultParameter newResult) {
        CopyOnWriteArraySet<ResultParameter> topUserResults = new CopyOnWriteArraySet<>();

        topUserResults.add(newResult);

        results.put(newResult.getKeyParameter(), topUserResults);
    }

    private void tryToAddNewResult(CopyOnWriteArraySet<ResultParameter> topResults, ResultParameter newResult) {
        if (topResults.contains(newResult)) {
            return;
        }

        topResults.stream()
                .max(createResultParameterComparator())
                .ifPresent(lastResultParameter -> processCompareLastWithNewResults(topResults, lastResultParameter, newResult));
    }

    public Comparator<ResultParameter> createResultParameterComparator() {
        return Comparator
                .comparing(ResultParameter::getFirstParameter, Comparator.reverseOrder())
                .thenComparing(ResultParameter::getSecondParameter, Comparator.reverseOrder());
    }

    private void processCompareLastWithNewResults(CopyOnWriteArraySet<ResultParameter> topResults,
                                                  ResultParameter lastResult,
                                                  ResultParameter newResult) {
        if (newResult.getFirstParameter() > lastResult.getFirstParameter()) {
            updateCollection(topResults, lastResult, newResult);
        } else if (newResult.getFirstParameter().equals(lastResult.getFirstParameter())) {
            if (newResult.getSecondParameter() > lastResult.getSecondParameter()) {
                updateCollection(topResults, lastResult, newResult);
            }
        }
    }

    private void updateCollection(CopyOnWriteArraySet<ResultParameter> topResults,
                                  ResultParameter lastResult,
                                  ResultParameter newResult) {
        topResults.remove(lastResult);
        topResults.add(newResult);
    }
}
