package io.github.coalangsoft.lib.dynamic;

import io.github.coalangsoft.lib.data.Func;

/**
 * Created by Matthias on 11.05.2017.
 */
public class DynamicString extends AbstractDynamicValue<String,DynamicString> {
    public DynamicString(String val) {
        super(val);
    }

    public DynamicString(Func<Void, String> func) {
        super(func);
    }

    @Override
    protected DynamicString instance(String v) {
        return new DynamicString(v);
    }

    @Override
    protected DynamicString instance(Func<Void, String> f) {
        return new DynamicString(f);
    }

    public DynamicDouble len(){
        return new DynamicDouble(new Func<Void, Double>() {
            @Override
            public Double call(Void aVoid) {
                return (double) get().length();
            }
        });
    }

}
