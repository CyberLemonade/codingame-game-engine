package com.codingame.gameengine.module.entities;

/**
 * Any PIXI Entity based on a texture shares the properties found in this <code>TextureBasedEntity</code>.
 *
 * @param <T> a subclass inheriting Entity, used in order to return <b>this</b> as a T instead of a <code>TextureBasedEntity</code>.
 */
public abstract class TextureBasedEntity<T extends Entity<?>> extends Entity<T> {

    /**
     * The list of supported PIXI blend modes and their associated constant.
     * 
     * @see <a href="http://pixijs.download/dev/docs/PIXI.html#.BLEND_MODES">PIXI BLEND_MODES</a>
     */
    public static enum BlendMode {
        NORMAL(0), ADD(1), MULTIPLY(2), SCREEN(3);
        private int value;

        private BlendMode(int value) {
            this.value = value;
        }

        private int getValue() {
            return value;
        }
    }

    private BlendMode blendMode;
    private double anchorX = 0, anchorY = 0;
    private int tint = 0xFFFFFF;

    TextureBasedEntity() {
        super();
    }

    /**
     * Returns the <code>BlendMode</code> this <code>TextureBasedEntity</code> is to be drawn with.
     * 
     * @see <a href="http://pixijs.download/dev/docs/PIXI.html#.BLEND_MODES">PIXI BLEND_MODES</a>
     * @return the <code>BlendMode</code> this <code>TextureBasedEntity</code> is to be drawn with.
     */
    public BlendMode getBlendMode() {
        return blendMode;
    }

    /**
     * Sets the blend mode for this <code>TextureBasedEntity</code>.
     * <p>
     * The possible values are found in <code>BlendMode</code>.
     * 
     * @see <a href="http://pixijs.download/dev/docs/PIXI.html#.BLEND_MODES">PIXI BLEND_MODES</a>
     * @param blendMode
     * @return this <code>TextureBasedEntity</code>.
     */
    public T setBlendMode(BlendMode blendMode) {
        this.blendMode = blendMode;
        set("blendMode", blendMode.getValue(), null);
        return self();
    }

    /**
     * Sets both the X and Y anchors of this <code>TextureBasedEntity</code> as a percentage of its width and height.
     * <p>
     * The point calculated by the anchors times the size of this <code>TextureBasedEntity</code> will be the origin for any rotation or scale.
     * 
     * @param anchor
     *            the percentage for both anchors of this <code>TextureBasedEntity</code>.
     * @return this <code>TextureBasedEntity</code>.
     */
    public T setAnchor(double anchor) {
        setAnchorX(anchor);
        setAnchorY(anchor);
        return self();
    }

    /**
     * Returns the X anchor of this <code>TextureBasedEntity</code> as a percentage of its width.
     * <p>
     * Default is 0.
     * 
     * @return the X anchor of this <code>TextureBasedEntity</code> as a percentage of its width.
     */
    public double getAnchorX() {
        return anchorX;
    }

    /**
     * Sets the X anchor of this <code>TextureBasedEntity</code> as a percentage of its width.
     * <p>
     * The point calculated by the anchors times the size of this <code>TextureBasedEntity</code> will be the origin for any rotation or scale.
     * 
     * @param anchorX
     *            the X anchor for this <code>TextureBasedEntity</code>.
     * @return this <code>TextureBasedEntity</code>.
     */
    public T setAnchorX(double anchorX) {
        return setAnchorX(anchorX, null);
    }

    /**
     * Sets the X anchor of this <code>TextureBasedEntity</code> as a percentage of its width.
     * <p>
     * The point calculated by the anchors times the size of this <code>TextureBasedEntity</code> will be the origin for any rotation or scale.
     * 
     * @param anchorX
     *            the X anchor for this <code>TextureBasedEntity</code>.
     * @param curve
     *            the transition to animate between values of this property.
     * @return this <code>TextureBasedEntity</code>.
     */
    public T setAnchorX(double anchorX, Curve curve) {
        this.anchorX = anchorX;
        set("anchorX", anchorX, curve);
        return self();
    }

    /**
     * Returns the Y anchor of this <code>TextureBasedEntity</code> as a percentage of its width.
     * <p>
     * Default is 0.
     * 
     * @return the Y anchor of this <code>TextureBasedEntity</code> as a percentage of its width.
     */
    public double getAnchorY() {
        return anchorY;
    }

    /**
     * Sets the Y anchor of this <code>TextureBasedEntity</code> as a percentage of its width.
     * <p>
     * The point calculated by the anchors times the size of this <code>TextureBasedEntity</code> will be the origin for any rotation or scale.
     * 
     * @param anchorY
     *            the Y anchor for this <code>TextureBasedEntity</code>.
     * @return this <code>TextureBasedEntity</code>.
     */
    public T setAnchorY(double anchorY) {
        return setAnchorY(anchorY, null);
    }

    /**
     * Sets the Y anchor of this <code>TextureBasedEntity</code> as a percentage of its width.
     * <p>
     * The point calculated by the anchors times the size of this <code>TextureBasedEntity</code> will be the origin for any rotation or scale.
     * 
     * @param anchorY
     *            the Y anchor for this <code>TextureBasedEntity</code>.
     * @param curve
     *            the transition to animate between values of this property.
     * @return this <code>TextureBasedEntity</code>.
     */
    public T setAnchorY(double anchorY, Curve curve) {
        this.anchorY = anchorY;
        set("anchorY", anchorY, curve);
        return self();
    }

    /**
     * Sets the tint of this <code>TextureBasedEntity</code> as an RGB integer.
     * 
     * @param color
     *            the tint of this <code>TextureBasedEntity</code>.
     * @return this <code>TextureBasedEntity</code>.
     * @exception IllegalArgumentException
     *                if color is not a valid RGB integer.
     */
    public T setTint(int color) {
        return setTint(color, null);
    }

    /**
     * Sets the tint of this <code>TextureBasedEntity</code> as an RGB integer.
     * 
     * @param color
     *            the tint of this <code>TextureBasedEntity</code>.
     * @param curve
     *            the transition to animate between values of this property.
     * @return this <code>TextureBasedEntity</code>.
     * @exception IllegalArgumentException
     *                if color is not a valid RGB integer.
     */
    public T setTint(int color, Curve curve) {
        requireValidColor(color);
        this.tint = color;
        set("tint", color, curve);
        return self();
    }

    /**
     * Returns the tint of this <code>TextureBasedEntity</code> as an RGB integer.
     * <p>
     * Default is 0xFFFFFF (white)
     * 
     * @return the tint of this <code>TextureBasedEntity</code>.
     */
    public int getTint() {
        return tint;
    }

}
