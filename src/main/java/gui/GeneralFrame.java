package gui;

/**
 * Created by max on 23.09.14.
 */
public interface GeneralFrame {

    /**
     * создание компонентов (наследников JComponent);
     * Здесь должны быть перечислены все компоненты вне зависимости
     * то того будет ли релизовывать из все, тот или иной вариант MainFrame
     */
    public void createJComponents();

    /**
     * размещение созданных компонентов на панелях
     */
    public void setJPanels();

    /**
     * установка нужных свойств для созданных компонентов,
     * например text, tooltip, font, listners, component name ...
     */
    public void setJCompProps();

}
