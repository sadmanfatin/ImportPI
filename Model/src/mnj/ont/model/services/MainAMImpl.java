package mnj.ont.model.services;

//import javax.faces.application.FacesMessage;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;

import java.sql.CallableStatement;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;


import mnj.ont.model.popup.FillBPOVOImpl;
import mnj.ont.model.views.ItemsVOImpl;
import mnj.ont.model.services.common.MainAM;

//import oracle.adf.model.OperationBinding;

//import oracle.binding.OperationBinding;

import mnj.ont.model.views.ImpPiLinesVOExImpl;

import mnj.ont.model.views.ImpPiLinesVOImpl;

import oracle.adf.model.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jdbc.OracleTypes;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Oct 31 16:09:44 BDT 2015
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MainAMImpl extends ApplicationModuleImpl implements MainAM {
    /**
     * This is the default constructor (do not remove).
     */
    public MainAMImpl() {
    }


    /** Start For Pop-Up of Amend **/
    
    public void callBpoFetch() {
        ViewObject populatevo = getFillBPO1();
         if (populatevo.getRowCount() == 0);
        RowSetIterator it = populatevo.createRowSetIterator("aaa");
        Row r[] = populatevo.getAllRowsInRange();
    for (Row row : r) {
          //  System.out.println("loop count");
            try {
                String flag = row.getAttribute("CheckBoxBPO").toString();
                System.out.println("Flag Code -->" + flag);
                if (flag.equals("true"))
                    populateBPOLines(row);


            } catch (Exception e)
            {
              ;
            }


        }

        it.closeRowSetIterator();
    }  
    
    public void populateBPOLines(Row poprow) {
         System.out.println(" in  populateBPOLines");
        ViewObject vo = getImpPiDetails1();
        
        // current pi line vo org id
        String OrgId = getOrgId();
       

        Row linerow = createBPOLines();

        linerow.setAttribute("PoNo",
                             getPopulateValue(poprow, "PoNumber"));
        linerow.setAttribute("PoDate",
                             getPopulateValue(poprow, "PoDate"));
        //////////////////////.......................mt.............................//
        linerow.setAttribute("PoValue",
                             getPopulateValue(poprow, "PoValue"));
        linerow.setAttribute("Attribute1",
                             getPopulateValue(poprow, "PaymentTerms"));
        linerow.setAttribute("Attribute2",
                             getPopulateValue(poprow, "ShipMode"));
        linerow.setAttribute("Attribute3",
                             getPopulateValue(poprow, "Buyer"));
                linerow.setAttribute("BuyerId",
                                     getPopulateValue(poprow, "BuyerId"));
                
                  System.out.println("=-=-=-=-=-=-= populateBPOLines  Season"+getPopulateValue(poprow, "Season")); 
                linerow.setAttribute("Attribute4",
                                     getPopulateValue(poprow, "Season"));
  
        linerow.setAttribute("Attribute8",
                             getPopulateValue(poprow, "Supplier"));
        linerow.setAttribute("Attribute9",getPopulateValue(poprow, "CurrencyCode"));
        
       // linerow.setAttribute("Attribute10",getPopulateValue(poprow, "StyleSeason"));
                     

         //   populateBpoLines1(OrgId);
            
           populateDetails(getPopulateValue(poprow, "PoNumber"), OrgId);
            
             //   System.out.println("=-=-=-=-=-=-=-=-==   after   populateDetails() method");  
            
            } //end of populateLines
    
            public void populateBpoLines1(String OrgId) {
             //   System.out.println("=-=-=-=-=-=in populateBpoLines1 method");

                ViewObject populatevo = getFillBPO1();
              //  System.out.println("Level 1");
                String SuppId = getSuppId();
                
                String vCurr = getCurrency();
            //    System.out.println("ORG_ID = " + OrgId + " AND VENDOR_ID = " + SuppId+" AND CURRENCY_CODE ='"+vCurr+"'");
                populatevo.setWhereClause("ORG_ID = " + OrgId + " AND VENDOR_ID = " + SuppId+" AND CURRENCY_CODE = '"+vCurr+"'");
                populatevo.executeQuery();
                System.out.println("ORG_ID = " + OrgId + " AND VENDOR_ID = " + SuppId+" AND CURRENCY_CODE = '"+vCurr+"'");

//                if (populatevo.getRowCount() == 0) {
//                    populatevo.setWhereClause(null);
//                    populatevo.setWhereClause("ORG_ID = " + OrgId);
//                    populatevo.executeQuery();
//                }


            } //end of populateOrderLines method
    
    
            public Row createBPOLines() {

                ViewObject vo = getImpPiDetails1();
                Row row = vo.createRow();
                vo.insertRow(row);
                row.setNewRowState(Row.STATUS_INITIALIZED);
                return row;
            } //end of createHeader
    
            public String getOrgId(){
                
                    
                ViewObject vo = getImpPiLines1();
                String OrgId = null;
                try {

                    OrgId =
                            vo.getCurrentRow().getAttribute("OrgId").toString();

                } catch (Exception e) {
                    // TODO: Add catch code
                    ;
                }
                    return OrgId;
            }
    
    public String getSuppId(){
        
            
        ViewObject vo = getImpPiLines1();
        String SuppId = null;
        try {

            SuppId =
                    vo.getCurrentRow().getAttribute("SupplierId").toString();

        } catch (Exception e) {
            // TODO: Add catch code
            ;
        }
            return SuppId;
    }
        
    public String getPopulateValue(Row r, String columnName) {

        String value = null;
        try {
            value = r.getAttribute(columnName).toString();
        } catch (Exception e) {
            ;
        }
        return value;
    }
    
    
    
    /** End For Amend **/


    /**
     * Container's getter for Items1.
     * @return Items1
     */
    public ItemsVOImpl getItems1() {
        return (ItemsVOImpl)findViewObject("Items1");
    }
    

    public void populateDetails(String po, String orgID){
            
        System.out.println("In Populate Item Details................" );
        System.out.println(".................po = "+po);
        System.out.println(".................org = "+orgID);
            ViewObject vo = getItems1(); // map view read only
            vo.setWhereClause("PO_NUMBER ='"+po+"' and ORG_ID ="+orgID);
            vo.executeQuery();
            
            RowSetIterator it = vo.createRowSetIterator("pp");
            
            
            while (it.hasNext()){
            //    System.out.println("=-=-=-=-=-=-= bug in populateDetails ");
                Row linerow = createDetails();
                Row Pop= it.next();
                linerow.setAttribute("ItemId",
                                     getPopulateValue(Pop, "ItemId"));
                linerow.setAttribute("Attribute1",
                                     getPopulateValue(Pop, "ConcSeg"));
                linerow.setAttribute("Attribute2",
                                     getPopulateValue(Pop, "ItemDesc"));
                linerow.setAttribute("Attribute3",
                                     getPopulateValue(Pop, "UnitPrice"));
                linerow.setAttribute("Attribute4",
                                     getPopulateValue(Pop, "Quantity"));
                linerow.setAttribute("TransDate1_1_1_1_1",
                                getPopulateValue(Pop, "NeedByDate"));
                linerow.setAttribute("Attribute9",getPopulateValue(Pop, "BuyerName"));
                linerow.setAttribute("Attribute10",getPopulateValue(Pop, "StyleSeason"));
                linerow.setAttribute("Attribute6",getPopulateValue(Pop, "GarmentQty"));
                
                /**  added by fatin on 9 may 2017 
                 * 
                 * splitting style~season  in item vo query and  inserting style in attribute11 and season  in attribute12
                 * 
                 * */
                
                linerow.setAttribute("Attribute11",getPopulateValue(Pop, "Style"));
                linerow.setAttribute("Attribute12",getPopulateValue(Pop, "Season"));
                
                linerow.setAttribute("PocId",getPopulateValue(Pop, "PocId"));    
               
           //    System.out.println("-------------------------- cc getPopulateValue(Pop, \"PocId\")  "+ getPopulateValue(Pop, "PocId"));
               
            }
        
        
        it.closeRowSetIterator();
        System.out.println("Out Populate Item Details" ); 
    }
    
    public Row createDetails() {

      //  System.out.println("In Create Item" );

        ViewObject vo = getImpPiItem1();
        Row row = vo.createRow();
        vo.insertRow(row);
        row.setNewRowState(Row.STATUS_INITIALIZED);
       // System.out.println("Out Create Item" );
        return row;
        
        
        
    } //end of createHeader

    /**
     * Container's getter for ImpPiLines1.
     * @return ImpPiLines1
     */
    public ViewObjectImpl getImpPiLines1() {
        return (ViewObjectImpl)findViewObject("ImpPiLines1");
    }

    /**
     * Container's getter for ImpPiDetails1.
     * @return ImpPiDetails1
     */
    public ViewObjectImpl getImpPiDetails1() {
        return (ViewObjectImpl)findViewObject("ImpPiDetails1");
    }

    /**
     * Container's getter for IedocImpPiDetailsFklLink1.
     * @return IedocImpPiDetailsFklLink1
     */
    public ViewLinkImpl getIedocImpPiDetailsFklLink1() {
        return (ViewLinkImpl)findViewLink("IedocImpPiDetailsFklLink1");
    }

    /**
     * Container's getter for ImpPiItem1.
     * @return ImpPiItem1
     */
    public ViewObjectImpl getImpPiItem1() {
        return (ViewObjectImpl)findViewObject("ImpPiItem1");
    }

    /**
     * Container's getter for IedocImpPiItemDetailFkLink1.
     * @return IedocImpPiItemDetailFkLink1
     */
    public ViewLinkImpl getIedocImpPiItemDetailFkLink1() {
        return (ViewLinkImpl)findViewLink("IedocImpPiItemDetailFkLink1");
    }
    
    
    public void SetTotalValue(String TotalVal){
        
       double aa = Double.parseDouble(TotalVal) ;
   //   if ( aa != 0.0 ) {
            
        ViewObject vo = getImpPiLines1();
       
          vo.getCurrentRow().setAttribute("TotalValue",TotalVal);
          
       }

    /**
     * Container's getter for ImpPiAdjustments1.
     * @return ImpPiAdjustments1
     */
    public ViewObjectImpl getImpPiAdjustments1() {
        return (ViewObjectImpl)findViewObject("ImpPiAdjustments1");
    }

    /**
     * Container's getter for IedocImpPiDetailsFkLink1.
     * @return IedocImpPiDetailsFkLink1
     */
    public ViewLinkImpl getIedocImpPiDetailsFkLink1() {
        return (ViewLinkImpl)findViewLink("IedocImpPiDetailsFkLink1");
    }
    /* Method to Populate WHO Column */

        public void setSessionValues(String orgId, String userId, String respId,
                                     String respAppl) {
          
            

            if (userId != null) {
                
                FacesContext fctx = FacesContext.getCurrentInstance();
                ExternalContext ectx = fctx.getExternalContext();
                HttpSession userSession = (HttpSession)ectx.getSession(false);          
                userSession.setAttribute("userId", userId);
                userSession.setAttribute("orgId", orgId);
                userSession.setAttribute("respId", respId);
                userSession.setAttribute("KeyFlag", getRespKey(respId));
                System.out.println("Responsibility Flag "+getRespKey(respId));
            }
        }

    /* End Method to Populate WHO Column */
/* PI Number Validation */
public int pinovalidation (String bblcnumber)
    
    {
       
        String status =null;
        String stmt = 
            "BEGIN  IEDOC_DOC_NO_PKG.IMPORT_SALE_PI_NO_UC (:1,:2); end;";
        
        int flag = 0 ;
        
        CallableStatement cs =
            getDBTransaction().createCallableStatement(stmt, 1);
        try {
            cs.registerOutParameter(2, OracleTypes.VARCHAR);
            cs.setString(1,bblcnumber);
            cs.execute();
            flag = cs.getInt(2);
            System.out.println("flag value in AM"+flag);
            //    status = cs.getString(1);
            
            cs.close();

        } 
        catch (Exception e)
        {
            status = e.getMessage();
        }       
       return flag;
        
    }
   
    
/* End PI Field Validation */   

/* Disabling Save Button For Specific Responsibility */
    public String getRespKey(String respId) {
        //returns MD if RESP_KEY = 'MJ_COMMERCIAL_HO' else returns GM
        String value = null;

        String stmt = "BEGIN :1 := IEDOC_DOC_NO_PKG.GETKEYPI(:2); end;";
        java.sql.CallableStatement cs =
            getDBTransaction().createCallableStatement(stmt, 1);
        try {
           
            
            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            cs.setString(2, respId);
            cs.execute();
            value = cs.getString(1);
            cs.close();
        } catch (Exception e) {
            ;
        }
        return value;
    }

/* End Disabling Save Button For Specific Responsibility */
   


    public String getCurrency(){
        
            
        ViewObject vo = getImpPiLines1();
        String vCurrency = null;
        try {

            vCurrency =
                    vo.getCurrentRow().getAttribute("Currency").toString();

        } catch (Exception e) {
            // TODO: Add catch code
            ;
        }
            return vCurrency;
    }


    private String getSeasonFromItem(String po, String OrgId) {
        
      //  System.out.println("=-=-=-=-=-=-=-=-= in   getSeasonFromItem   method ");
        String Season=null ; 
        ViewObject itemVo = getItems1(); // map view read only
       // System.out.println("=-=-=-=-=-=-=-=-= vo.firts " + "PO_NUMBER ='"+po+"' and ORG_ID ="+OrgId );
        itemVo.setWhereClause("PO_NUMBER ='"+po+"' and ORG_ID ="+OrgId);
        itemVo.executeQuery();
        
        RowSetIterator itt = itemVo.createRowSetIterator("itt");
        
        if(itt.first() != null){
            //  System.out.println("=-=-=-=-=-=-=-=-= in  if(vo.first() != null)   loop ");
            Season = itt.first().getAttribute("Season").toString();
              
          }else{
           //  System.out.println("=-=-=-=-=-=-=-=-= in  else (vo.first() == null)   loop ");
            itt.closeRowSetIterator();
                  return null;
         }
        
        itt.closeRowSetIterator();  
       return Season;
       
    }


    /**
     * Container's getter for ImpPiLinesVOEx1.
     * @return ImpPiLinesVOEx1
     */
    public ImpPiLinesVOExImpl getImpPiLinesVOEx1() {
        return (ImpPiLinesVOExImpl)findViewObject("ImpPiLinesVOEx1");
    }

    /**
     * Container's getter for ItemQtyDetailVO1.
     * @return ItemQtyDetailVO1
     */
    public ViewObjectImpl getItemQtyDetailVO1() {
        return (ViewObjectImpl)findViewObject("ItemQtyDetailVO1");
    }

    /**
     * Container's getter for LineVO_Vs_ItemQtyDetailVO_VL1.
     * @return LineVO_Vs_ItemQtyDetailVO_VL1
     */
    public ViewLinkImpl getLineVO_Vs_ItemQtyDetailVO_VL1() {
        return (ViewLinkImpl)findViewLink("LineVO_Vs_ItemQtyDetailVO_VL1");
    }

    /**
     * Container's getter for FillBPOVO1.
     * @return FillBPOVO1
     */
    public FillBPOVOImpl getFillBPO1() {
        return (FillBPOVOImpl)findViewObject("FillBPO1");
    }

    /**
     * Container's getter for PiLIneVO_Vs_FillBPOVo_vl1.
     * @return PiLIneVO_Vs_FillBPOVo_vl1
     */
    public ViewLinkImpl getPiLIneVO_Vs_FillBPOVo_vl1() {
        return (ViewLinkImpl)findViewLink("PiLIneVO_Vs_FillBPOVo_vl1");
    }
}
