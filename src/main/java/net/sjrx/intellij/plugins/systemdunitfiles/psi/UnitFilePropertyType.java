package net.sjrx.intellij.plugins.systemdunitfiles.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import net.sjrx.intellij.plugins.systemdunitfiles.generated.UnitFileElementTypeHolder;
import org.jetbrains.annotations.NotNull;

public class UnitFilePropertyType extends ASTWrapperPsiElement {

  public UnitFilePropertyType(@NotNull ASTNode node) {
    super(node);
  }

  /**
   * Returns the key for the property.
   *
   * @return the key for this property
   */
  public String getKey() {
    ASTNode keyNode = this.getKeyNode();

    return keyNode.getText().replaceAll("\\\\ ", " ");
  }

  /**
   * Returns the key for the property.
   *
   * @return the key for this property
   */
  public ASTNode getKeyNode() {
    ASTNode keyNode = this.getNode().findChildByType(UnitFileElementTypeHolder.KEY);
    if (keyNode != null) {
      return keyNode;
    } else {
      throw new IllegalStateException("Every instance of " + this.getClass() + "should have a key node underneath");
    }
  }
  
  /**
   * Returns the key for the property.
   *
   * @return the key for this property
   */
  public ASTNode getValueNode() {
    ASTNode keyNode = this.getNode().findChildByType(UnitFileElementTypeHolder.VALUE);
    if (keyNode != null) {
      return keyNode;
    } else {
      throw new IllegalStateException("Every instance of " + this.getClass() + "should have a key node underneath");
    }
  }
  
  /**
   * Returns the value for the property.
   *
   * @return the value for this property
   */
  public String getValue() {
    return getValueNode().getText();
  }

}
