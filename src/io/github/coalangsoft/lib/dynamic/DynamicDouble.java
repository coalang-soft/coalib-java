package io.github.coalangsoft.lib.dynamic;

import io.github.coalangsoft.lib.data.Func;

/**
 * Created by Matthias on 11.05.2017.
 */
public class DynamicDouble extends AbstractDynamicNumber<Double, DynamicDouble> {

    public DynamicDouble(Double val) {
        super(val);
    }

    public DynamicDouble(Func<Void, Double> f) {
        super(f);
    }

    @Override
    protected DynamicDouble instance(Func<Void, Double> f) {
        return new DynamicDouble(f);
    }

    @Override
    protected DynamicDouble instance(Double v) {
        return new DynamicDouble(v);
    }

    @Override
    protected Double addImpl(Double a, Double b) {
        return a+b;
    }

    @Override
    protected Double subImpl(Double a, Double b) {
        return a-b;
    }

    @Override
    protected Double mulImpl(Double a, Double b) {
        return a*b;
    }

    @Override
    protected Double divImpl(Double a, Double b) {
        return a/b;
    }

    @Override
    protected Double powImpl(Double a, Double b) {
        return Math.pow(a,b);
    }

    @Override
    protected boolean lssImpl(Double a, Double b) {
        return a<b;
    }

    @Override
    protected boolean gtrImpl(Double a, Double b) {
        return a>b;
    }

    @Override
    protected Double modImpl(Double a, Double b) {
        return a % b;
    }

}
