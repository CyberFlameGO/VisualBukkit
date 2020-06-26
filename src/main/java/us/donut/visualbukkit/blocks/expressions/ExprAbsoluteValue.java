package us.donut.visualbukkit.blocks.expressions;

import us.donut.visualbukkit.blocks.ExpressionBlock;
import us.donut.visualbukkit.blocks.annotations.Category;
import us.donut.visualbukkit.blocks.annotations.Description;
import us.donut.visualbukkit.blocks.syntax.SyntaxNode;

@Category("Math")
@Description({"The absolute value of a number", "Returns: number"})
public class ExprAbsoluteValue extends ExpressionBlock<Double> {

    @Override
    protected SyntaxNode init() {
        return new SyntaxNode("absolute value of", double.class);
    }

    @Override
    public String toJava() {
        return "Math.abs(" + arg(0) + ")";
    }
}