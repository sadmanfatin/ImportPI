package mnj.ont.model.entities;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Feb 04 16:31:22 BDT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ImpPiAdjustmentsEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        ImpPiAdjustmentId {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getImpPiAdjustmentId();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setImpPiAdjustmentId((Number)value);
            }
        }
        ,
        ImpPiLineId {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getImpPiLineId();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setImpPiLineId((Number)value);
            }
        }
        ,
        FreightCharges {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getFreightCharges();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setFreightCharges((Number)value);
            }
        }
        ,
        BankCharges {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getBankCharges();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setBankCharges((Number)value);
            }
        }
        ,
        HandlingCharges {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getHandlingCharges();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setHandlingCharges((Number)value);
            }
        }
        ,
        Discount {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getDiscount();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setDiscount((Number)value);
            }
        }
        ,
        Other {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getOther();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setOther((Number)value);
            }
        }
        ,
        LastUpdateLogin {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getLastUpdateLogin();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setLastUpdateLogin((Number)value);
            }
        }
        ,
        LastUpdateDate {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getLastUpdateDate();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setLastUpdateDate((Date)value);
            }
        }
        ,
        LastUpdatedBy {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getLastUpdatedBy();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setLastUpdatedBy((Number)value);
            }
        }
        ,
        CreationDate {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getCreationDate();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setCreationDate((Date)value);
            }
        }
        ,
        CreatedBy {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setCreatedBy((Number)value);
            }
        }
        ,
        Attribute1 {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getAttribute1();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setAttribute1((Number)value);
            }
        }
        ,
        Attribute2 {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getAttribute2();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setAttribute2((Number)value);
            }
        }
        ,
        Attribute3 {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getAttribute3();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setAttribute3((Number)value);
            }
        }
        ,
        Attribute4 {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getAttribute4();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setAttribute4((Number)value);
            }
        }
        ,
        Attribute5 {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getAttribute5();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setAttribute5((Number)value);
            }
        }
        ,
        Attribute6 {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getAttribute6();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setAttribute6((Number)value);
            }
        }
        ,
        Attribute7 {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getAttribute7();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setAttribute7((Number)value);
            }
        }
        ,
        Attribute8 {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getAttribute8();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setAttribute8((Number)value);
            }
        }
        ,
        Attribute9 {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getAttribute9();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setAttribute9((Number)value);
            }
        }
        ,
        Attribute10 {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getAttribute10();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setAttribute10((Number)value);
            }
        }
        ,
        ImpPiLines {
            public Object get(ImpPiAdjustmentsEOImpl obj) {
                return obj.getImpPiLines();
            }

            public void put(ImpPiAdjustmentsEOImpl obj, Object value) {
                obj.setImpPiLines((ImpPiLinesEOImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(ImpPiAdjustmentsEOImpl object);

        public abstract void put(ImpPiAdjustmentsEOImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }

    public static final int IMPPIADJUSTMENTID = AttributesEnum.ImpPiAdjustmentId.index();
    public static final int IMPPILINEID = AttributesEnum.ImpPiLineId.index();
    public static final int FREIGHTCHARGES = AttributesEnum.FreightCharges.index();
    public static final int BANKCHARGES = AttributesEnum.BankCharges.index();
    public static final int HANDLINGCHARGES = AttributesEnum.HandlingCharges.index();
    public static final int DISCOUNT = AttributesEnum.Discount.index();
    public static final int OTHER = AttributesEnum.Other.index();
    public static final int LASTUPDATELOGIN = AttributesEnum.LastUpdateLogin.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int ATTRIBUTE1 = AttributesEnum.Attribute1.index();
    public static final int ATTRIBUTE2 = AttributesEnum.Attribute2.index();
    public static final int ATTRIBUTE3 = AttributesEnum.Attribute3.index();
    public static final int ATTRIBUTE4 = AttributesEnum.Attribute4.index();
    public static final int ATTRIBUTE5 = AttributesEnum.Attribute5.index();
    public static final int ATTRIBUTE6 = AttributesEnum.Attribute6.index();
    public static final int ATTRIBUTE7 = AttributesEnum.Attribute7.index();
    public static final int ATTRIBUTE8 = AttributesEnum.Attribute8.index();
    public static final int ATTRIBUTE9 = AttributesEnum.Attribute9.index();
    public static final int ATTRIBUTE10 = AttributesEnum.Attribute10.index();
    public static final int IMPPILINES = AttributesEnum.ImpPiLines.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ImpPiAdjustmentsEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("mnj.ont.model.entities.ImpPiAdjustmentsEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for ImpPiAdjustmentId, using the alias name ImpPiAdjustmentId.
     * @return the ImpPiAdjustmentId
     */
    public Number getImpPiAdjustmentId() {
        return (Number)getAttributeInternal(IMPPIADJUSTMENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ImpPiAdjustmentId.
     * @param value value to set the ImpPiAdjustmentId
     */
    public void setImpPiAdjustmentId(Number value) {
        setAttributeInternal(IMPPIADJUSTMENTID, value);
    }

    /**
     * Gets the attribute value for ImpPiLineId, using the alias name ImpPiLineId.
     * @return the ImpPiLineId
     */
    public Number getImpPiLineId() {
        return (Number)getAttributeInternal(IMPPILINEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ImpPiLineId.
     * @param value value to set the ImpPiLineId
     */
    public void setImpPiLineId(Number value) {
        setAttributeInternal(IMPPILINEID, value);
    }

    /**
     * Gets the attribute value for FreightCharges, using the alias name FreightCharges.
     * @return the FreightCharges
     */
    public Number getFreightCharges() {
        return (Number)getAttributeInternal(FREIGHTCHARGES);
    }

    /**
     * Sets <code>value</code> as the attribute value for FreightCharges.
     * @param value value to set the FreightCharges
     */
    public void setFreightCharges(Number value) {
        setAttributeInternal(FREIGHTCHARGES, value);
    }

    /**
     * Gets the attribute value for BankCharges, using the alias name BankCharges.
     * @return the BankCharges
     */
    public Number getBankCharges() {
        return (Number)getAttributeInternal(BANKCHARGES);
    }

    /**
     * Sets <code>value</code> as the attribute value for BankCharges.
     * @param value value to set the BankCharges
     */
    public void setBankCharges(Number value) {
        setAttributeInternal(BANKCHARGES, value);
    }

    /**
     * Gets the attribute value for HandlingCharges, using the alias name HandlingCharges.
     * @return the HandlingCharges
     */
    public Number getHandlingCharges() {
        return (Number)getAttributeInternal(HANDLINGCHARGES);
    }

    /**
     * Sets <code>value</code> as the attribute value for HandlingCharges.
     * @param value value to set the HandlingCharges
     */
    public void setHandlingCharges(Number value) {
        setAttributeInternal(HANDLINGCHARGES, value);
    }

    /**
     * Gets the attribute value for Discount, using the alias name Discount.
     * @return the Discount
     */
    public Number getDiscount() {
        return (Number)getAttributeInternal(DISCOUNT);
    }

    /**
     * Sets <code>value</code> as the attribute value for Discount.
     * @param value value to set the Discount
     */
    public void setDiscount(Number value) {
        setAttributeInternal(DISCOUNT, value);
    }

    /**
     * Gets the attribute value for Other, using the alias name Other.
     * @return the Other
     */
    public Number getOther() {
        return (Number)getAttributeInternal(OTHER);
    }

    /**
     * Sets <code>value</code> as the attribute value for Other.
     * @param value value to set the Other
     */
    public void setOther(Number value) {
        setAttributeInternal(OTHER, value);
    }

    /**
     * Gets the attribute value for LastUpdateLogin, using the alias name LastUpdateLogin.
     * @return the LastUpdateLogin
     */
    public Number getLastUpdateLogin() {
        return (Number)getAttributeInternal(LASTUPDATELOGIN);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdateLogin.
     * @param value value to set the LastUpdateLogin
     */
    public void setLastUpdateLogin(Number value) {
        setAttributeInternal(LASTUPDATELOGIN, value);
    }

    /**
     * Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate.
     * @return the LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date)getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdateDate.
     * @param value value to set the LastUpdateDate
     */
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the LastUpdatedBy
     */
    public Number getLastUpdatedBy() {
        return (Number)getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedBy.
     * @param value value to set the LastUpdatedBy
     */
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the CreationDate
     */
    public Date getCreationDate() {
        return (Date)getAttributeInternal(CREATIONDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreationDate.
     * @param value value to set the CreationDate
     */
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the CreatedBy
     */
    public Number getCreatedBy() {
        return (Number)getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for Attribute1, using the alias name Attribute1.
     * @return the Attribute1
     */
    public Number getAttribute1() {
        return (Number)getAttributeInternal(ATTRIBUTE1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute1.
     * @param value value to set the Attribute1
     */
    public void setAttribute1(Number value) {
        setAttributeInternal(ATTRIBUTE1, value);
    }

    /**
     * Gets the attribute value for Attribute2, using the alias name Attribute2.
     * @return the Attribute2
     */
    public Number getAttribute2() {
        return (Number)getAttributeInternal(ATTRIBUTE2);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute2.
     * @param value value to set the Attribute2
     */
    public void setAttribute2(Number value) {
        setAttributeInternal(ATTRIBUTE2, value);
    }

    /**
     * Gets the attribute value for Attribute3, using the alias name Attribute3.
     * @return the Attribute3
     */
    public Number getAttribute3() {
        return (Number)getAttributeInternal(ATTRIBUTE3);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute3.
     * @param value value to set the Attribute3
     */
    public void setAttribute3(Number value) {
        setAttributeInternal(ATTRIBUTE3, value);
    }

    /**
     * Gets the attribute value for Attribute4, using the alias name Attribute4.
     * @return the Attribute4
     */
    public Number getAttribute4() {
        return (Number)getAttributeInternal(ATTRIBUTE4);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute4.
     * @param value value to set the Attribute4
     */
    public void setAttribute4(Number value) {
        setAttributeInternal(ATTRIBUTE4, value);
    }

    /**
     * Gets the attribute value for Attribute5, using the alias name Attribute5.
     * @return the Attribute5
     */
    public Number getAttribute5() {
        return (Number)getAttributeInternal(ATTRIBUTE5);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute5.
     * @param value value to set the Attribute5
     */
    public void setAttribute5(Number value) {
        setAttributeInternal(ATTRIBUTE5, value);
    }

    /**
     * Gets the attribute value for Attribute6, using the alias name Attribute6.
     * @return the Attribute6
     */
    public Number getAttribute6() {
        return (Number)getAttributeInternal(ATTRIBUTE6);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute6.
     * @param value value to set the Attribute6
     */
    public void setAttribute6(Number value) {
        setAttributeInternal(ATTRIBUTE6, value);
    }

    /**
     * Gets the attribute value for Attribute7, using the alias name Attribute7.
     * @return the Attribute7
     */
    public Number getAttribute7() {
        return (Number)getAttributeInternal(ATTRIBUTE7);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute7.
     * @param value value to set the Attribute7
     */
    public void setAttribute7(Number value) {
        setAttributeInternal(ATTRIBUTE7, value);
    }

    /**
     * Gets the attribute value for Attribute8, using the alias name Attribute8.
     * @return the Attribute8
     */
    public Number getAttribute8() {
        return (Number)getAttributeInternal(ATTRIBUTE8);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute8.
     * @param value value to set the Attribute8
     */
    public void setAttribute8(Number value) {
        setAttributeInternal(ATTRIBUTE8, value);
    }

    /**
     * Gets the attribute value for Attribute9, using the alias name Attribute9.
     * @return the Attribute9
     */
    public Number getAttribute9() {
        return (Number)getAttributeInternal(ATTRIBUTE9);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute9.
     * @param value value to set the Attribute9
     */
    public void setAttribute9(Number value) {
        setAttributeInternal(ATTRIBUTE9, value);
    }

    /**
     * Gets the attribute value for Attribute10, using the alias name Attribute10.
     * @return the Attribute10
     */
    public Number getAttribute10() {
        return (Number)getAttributeInternal(ATTRIBUTE10);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute10.
     * @param value value to set the Attribute10
     */
    public void setAttribute10(Number value) {
        setAttributeInternal(ATTRIBUTE10, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    /**
     * @return the associated entity ImpPiLinesEOImpl.
     */
    public ImpPiLinesEOImpl getImpPiLines() {
        return (ImpPiLinesEOImpl)getAttributeInternal(IMPPILINES);
    }

    /**
     * Sets <code>value</code> as the associated entity ImpPiLinesEOImpl.
     */
    public void setImpPiLines(ImpPiLinesEOImpl value) {
        setAttributeInternal(IMPPILINES, value);
    }

    /**
     * @param impPiAdjustmentId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number impPiAdjustmentId) {
        return new Key(new Object[]{impPiAdjustmentId});
    }


    protected void create(AttributeList attributeList) {
      super.create(attributeList);
      /* Sequence Generation Code of Header by PwC */  
      oracle.jbo.server.SequenceImpl s = new oracle.jbo.server.SequenceImpl("IEDOC_IMP_PI_ADJUSTMENTS_S",getDBTransaction());          
      oracle.jbo.domain.Number sVal = s.getSequenceNumber();          
      setImpPiAdjustmentId(sVal);
      /* End Sequence Generation Code of Header by PwC */
    }

}