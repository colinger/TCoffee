package io.colinger.tgc;

import lombok.Data;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class SpELTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("#root.purchaseName");
        Order order = new Order();
        order.setPurchaseName("张三");
        assertSame("张三", expression.getValue(order));
    }

    @Data
    class Order {
        private String purchaseName;
    }

    @Test
    public void expressTest(){
        Pattern pattern = Pattern.compile("\\{\\s*(\\w*)\\s*\\{(.*?)}}");
        String expressionTemplate = "{查询用户{#member.userId}}";
//        expressionTemplate = "修改了订单的配送员：从“#oldDeliveryUserId”, 修改到“#request.userId”";
//        expressionTemplate = "{查询用户{#member.userId}}";
        //
        //”
        Matcher matcher = pattern.matcher(expressionTemplate);
        while (matcher.find()) {
            String expression = matcher.group(2);
            System.out.println(expression);
        }
    }
}
