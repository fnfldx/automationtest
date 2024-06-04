package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static enums.TranslationKey.APPAREL_BUTTON;
import static enums.TranslationKey.BOOKS_BUTTON;
import static enums.TranslationKey.FRAGRANCE_BUTTON;
import static enums.TranslationKey.HAIR_CARE_BUTTON;
import static enums.TranslationKey.HOME_BUTTON;
import static enums.TranslationKey.MAKEUP_BUTTON;
import static enums.TranslationKey.MEN_BUTTON;
import static enums.TranslationKey.SKINCARE_BUTTON;

@Getter
@RequiredArgsConstructor
@ToString
public enum CategoryMenuButton {
    HOME(HOME_BUTTON.getTranslation()),
    APPAREL_AND_ACCESSORIES(APPAREL_BUTTON.getTranslation()),
    MAKEUP(MAKEUP_BUTTON.getTranslation()),
    SKINCARE(SKINCARE_BUTTON.getTranslation()),
    FRAGRANCE(FRAGRANCE_BUTTON.getTranslation()),
    MEN(MEN_BUTTON.getTranslation()),
    HAIR_CARE(HAIR_CARE_BUTTON.getTranslation()),
    BOOKS(BOOKS_BUTTON.getTranslation());

    private final String text;
}