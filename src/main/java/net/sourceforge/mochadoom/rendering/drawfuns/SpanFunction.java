package net.sourceforge.mochadoom.rendering.drawfuns;

/**
 * Either draws a column or a span
 *
 * @author velktron
 */

public interface SpanFunction<T, V> {
    public void invoke();

    public void invoke(SpanVars<T, V> dsvars);

}