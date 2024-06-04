package pages.cartPage.shoppingCartTable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static enums.TranslationKey.IMAGE_HEADER;
import static enums.TranslationKey.MODEL_HEADER;
import static enums.TranslationKey.NAME_HEADER;
import static enums.TranslationKey.QUANTITY_HEADER;
import static enums.TranslationKey.REMOVE_HEADER;
import static enums.TranslationKey.TOTAL_HEADER;
import static enums.TranslationKey.UNIT_PRICE_HEADER;

@Getter
@ToString
@RequiredArgsConstructor
public enum ShoppingCartHeader {
    IMAGE(IMAGE_HEADER.getTranslation(), 0),
    NAME(NAME_HEADER.getTranslation(), 1),
    MODEL(MODEL_HEADER.getTranslation(), 2),
    UNIT_PRICE(UNIT_PRICE_HEADER.getTranslation(), 3),
    QUANTITY(QUANTITY_HEADER.getTranslation(), 4),
    TOTAL(TOTAL_HEADER.getTranslation(), 5),
    REMOVE(REMOVE_HEADER.getTranslation(), 6);

    public final String header;
    public final int columnIndex;
}