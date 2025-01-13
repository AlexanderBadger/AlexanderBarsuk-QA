package main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static main.constants.IntegerConstants.ATTEMPTS;
import static main.constants.LogMessages.CANT_FIND_ELEMENT_LOG;

public class AllPages {
    /**
     * Ожидает появления элемента на странице по указанному XPath.
     *
     * @param xpath строка, представляющая XPath выражение для элемента,
     *              которого необходимо дождаться.
     * @throws AssertionError если элемент не становится видимым в течение 20 попыток.
     */
    public void waitForElement(String xpath) {
        SelenideElement element = $x(xpath);
        int attempts = 0;
        int maxAttempts = ATTEMPTS;
        while (attempts < maxAttempts) {
            try {
                element.shouldBe(Condition.visible);
                return;
            } catch (Exception e) {
                attempts++;
                if (attempts == maxAttempts) {
                    throw new AssertionError(String.format(CANT_FIND_ELEMENT_LOG, xpath, maxAttempts));
                }
            }
        }
    }
}