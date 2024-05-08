package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static engine.property.manager.PropertyManager.tr;

@Getter
@RequiredArgsConstructor
@ToString
public enum CategoryMenuButton {
    HOME(tr.getString("homeButton")),
    APPAREL_AND_ACCESSORIES(tr.getString("apparelButton")),
    MAKEUP(tr.getString("makeupButton")),
    SKINCARE(tr.getString("skincareButton")),
    FRAGRANCE(tr.getString("fragranceButton")),
    MEN(tr.getString("menButton")),
    HAIR_CARE(tr.getString("hairCareButton")),
    BOOKS(tr.getString("booksButton"));

    private final String text;
}