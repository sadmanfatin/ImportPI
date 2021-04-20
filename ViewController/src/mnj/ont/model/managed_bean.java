package mnj.ont.model;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Locale;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import mnj.ont.model.services.MainAMImpl;

import mnj.ont.model.views.ImpPiLinesVORowImpl;

import oracle.adf.model.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupCanceledEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;


import oracle.binding.OperationBinding;



import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.Row;

import oracle.jbo.RowSet;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import  org.apache.myfaces.trinidad.util.Service;

public class managed_bean {

  //  private RichTable fillBPO;
    private RichInputText orgId;
    private RichTable fillItem;
    private RichTable bpOTable;
    private RichTable itemsTable;
    private RichInputText supplierId;
    private RichInputText piValue;
    private RichInputText att1;
    private RichInputText freightCharges;
    private RichInputText bankCharges;
    private RichInputText handlingCharges;
    private RichInputText discount;
    private RichInputText other;
    private RichInputText documentNumber;
    private RichInputDate proposalDate;
    private RichInputText impLine_ID_Bind;
    private RichOutputText bblcNoAgainstPi;
    private RichInputText piNo;
    
    
    
    MainAMImpl appM = getAppModuleImpl();
    private RichPanelFormLayout bbLCsearchForm;
    private RichPanelTabbed mainTab;
    private RichShowDetailItem allPiTab;
    private RichTable fillBpoPopYpTable;

    public MainAMImpl getAppModuleImpl() {
        DCBindingContainer bindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        //BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =
            bindingContainer.findDataControl("MainAMDataControl"); // Name of application module in datacontrolBinding.cpx
        MainAMImpl appM = (MainAMImpl)dc.getDataProvider();
        return appM;
    }
    


    /** Bean Coding For FILL BPO Tab **/
    
    public void editPopupFetchListener(PopupFetchEvent popupFetchEvent) {
                
        ViewObject lineVo = appM.getImpPiLines1();
      
        ViewObject fillBpoVo = appM.getFillBPO1();
         fillBpoVo.setWhereClause( null );
         fillBpoVo.executeQuery();
         
        RowSet detailRows ;
        try{
            detailRows = (RowSet)lineVo.getCurrentRow().getAttribute("ImpPiDetails");
        }catch(Exception e){
            return;
        }
        
        if (detailRows.getRowCount()>0){
            StringBuilder spos= new StringBuilder();
             spos.append("(");
            while (detailRows.hasNext()){
                Row row = detailRows.next();
                spos.append("'");
                try{
                    spos.append(row.getAttribute("PoNo").toString());
                }catch(Exception e){
                    spos.append("demoPo");
                }
              
               spos.append("'");
               spos.append(",");
            }
            spos.deleteCharAt(spos.length()-1);
            spos.append(")");
          //  System.out.println("********************88   "+ "PO_NUMBER NOT IN " + spos);
            fillBpoVo.setWhereClause( "PO_NUMBER NOT IN " + spos);
        }  
        else{
            fillBpoVo.setWhereClause( null );
        }
        
       fillBpoVo.executeQuery();
       
    AdfFacesContext adfFaceContext = AdfFacesContext.getCurrentInstance();
    adfFaceContext.addPartialTarget(fillBpoPopYpTable);
              
}
    public void setWhereClause(){
        
        
        oracle.binding.OperationBinding operationBinding = executeOperation("populateBpoLines1");
        System.out.println("sabih Error 1   "+getOrgId().getValue());
        operationBinding.getParamsMap().put("OrgId", getOrgId().getValue());
        System.out.println("sabih Error 2   "+getOrgId().getValue());
        
        operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
           System.out.println("if errors-->");
    //            List errors = operationBinding.getErrors();
    //            System.out.println(@);
        }
    }
    
    public void editDialogListener(DialogEvent dialogEvent) {
           if (dialogEvent.getOutcome().name().equals("ok")) {     
            FillBPO();
               AdfFacesContext.getCurrentInstance().addPartialTarget(bpOTable); 
               AdfFacesContext.getCurrentInstance().addPartialTarget(itemsTable); 
           } else if (dialogEvent.getOutcome().name().equals("cancel")) {          
            ;
           }
       }
    
    public  void FillBPO() {
        
          oracle.binding.OperationBinding operationBinding = executeOperation("callBpoFetch");
          operationBinding.execute();
       }
    public oracle.binding.BindingContainer getBindings() {
           return BindingContext.getCurrent().getCurrentBindingsEntry();
       }
    
    public oracle.binding.OperationBinding executeOperation(String operation) {
        oracle.binding.OperationBinding createParam = getBindingsCont().getOperationBinding(operation);
        return createParam;

    }
    
    /*****Generic Method to Get BindingContainer**/
        public oracle.binding.BindingContainer getBindingsCont() {
            return BindingContext.getCurrent().getCurrentBindingsEntry();
        }


    public void editPopupCancelListener(PopupCanceledEvent popupCanceledEvent) {
           
       }

    /** End Bean Coding For FILL BPO Tab **/
    
    
    
 //   public void setFillBPO(RichTable fillBPO) {
   //     this.fillBPO = fillBPO;
   // }

  //  public RichTable getFillBPO() {
   //     return fillBPO;
   // }

    public void setOrgId(RichInputText orgId) {
        this.orgId = orgId;
        FacesContext fctx = FacesContext.getCurrentInstance();
                ExternalContext ectx = fctx.getExternalContext();
                HttpSession userSession = (HttpSession)ectx.getSession(false);
                userSession.setAttribute("OrgID", orgId.getValue());
     //   System.out.println("ABC "+userSession.getAttribute("OrgID"));
                

    
    }

    public RichInputText getOrgId() {
        return orgId;
    }

 //   public void setFillItem(RichTable fillItem) {
  //      this.fillItem = fillItem;
  //  }

  //  public RichTable getFillItem() {
   //     return fillItem;
   // }

    public void setBpOTable(RichTable bpOTable) {
        this.bpOTable = bpOTable;
    }

    public RichTable getBpOTable() {
        return bpOTable;
    }

    public void setItemsTable(RichTable itemsTable) {
        this.itemsTable = itemsTable;
    }

    public RichTable getItemsTable() {
        return itemsTable;
    }

    public void setSupplierId(RichInputText supplierId) {
        this.supplierId = supplierId;
    }

    public RichInputText getSupplierId() {
        return supplierId;
    }

    public void setPiValue(RichInputText piValue) {
        this.piValue = piValue;
    }

    public RichInputText getPiValue() {
        return piValue;
    }



    /************** Code To Get Total ***********************/
       
        public String getPiTotalValue() {
        
        
            ViewObject findViewObject =appM.getImpPiDetails1();
           
            RowSetIterator it = findViewObject.createRowSetIterator("tt");
                   double val = 0.0, total = 0.0,
                          freightcharge = 0.0 , bankcharge = 0.0,
                        handlingcharge = 0.0 , discount = 0.0 ,
                       other = 0.0 ;
                   
                    while (it.hasNext()){
                      
                           Row r = it.next();
                           try {
                                  val = Double.parseDouble(r.getAttribute("PoValue").toString());
                             //  BigDecimal n = new BigDecimal(r.getAttribute("PoValue").toString());
                               
                               System.out.println(".......................val "+val);
                               System.out.println(".......................povalue row "+r.getAttribute("PoValue").toString());
                           }catch (Exception e ){;}
                           
                           total = total + val ;
                   } //end of while loop
                   it.closeRowSetIterator();
                 
                   try {
            freightcharge =
                    Double.parseDouble(getFreightCharges().getValue().toString());
        } catch (Exception nfe) {
            // TODO: Add catch code
            freightcharge = 0.0 ;
        }
                   try {
            bankcharge =
                    Double.parseDouble(getBankCharges().getValue().toString());
        } catch (Exception nfe) {
            // TODO: Add catch code
            bankcharge = 0.0;
        } 
                   try {
            handlingcharge =
                    Double.parseDouble(getHandlingCharges().getValue().toString());
        } catch (Exception nfe) {
            // TODO: Add catch code
            handlingcharge = 0.0;
        } 
                   try {
            discount = Double.parseDouble(getDiscount().getValue().toString());
        } catch (Exception nfe) {
            // TODO: Add catch code
            discount = 0.0;
        }
        try {
            other = Double.parseDouble(getOther().getValue().toString());
        } catch (Exception nfe) {
            // TODO: Add catch code
            other = 0.0;
        }
                   
                   total = total + 
                           freightcharge   + 
                           other   + 
                           discount   + 
                           handlingcharge   + 
                           bankcharge ;
                   
                   System.out.println("total of get oi total"+total);
                   long l = (new Double(total)).longValue();
                   //BigDecimal n = new BigDecimal();
                   BigDecimal b = BigDecimal.valueOf(total);
                   System.out.println("total of get oi total L"+l);
                   System.out.println("total of get oi total LB"+b.toString());
                   
                   
                   
                   
                   
                   return b.toString() ; 
                   
                   
                   
                   
               }


    public void setAtt1(RichInputText att1) {
        this.att1 = att1;
    }

    public RichInputText getAtt1() {
        return att1;
    }


    public String commitNew() {
        
        ViewObject piLineVo = appM.getImpPiLines1();
        
         Double totalVal ;
        totalVal =Double.parseDouble(getPiTotalValue());
       
         piLineVo.getCurrentRow().setAttribute("TotalValue", totalVal);
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(piValue);
         
       
        appM.getDBTransaction().commit();
       
        return null;
        
        
    }

    public void setFreightCharges(RichInputText freightCharges) {
        this.freightCharges = freightCharges;
    }

    public RichInputText getFreightCharges() {
        return freightCharges;
    }

    public void setBankCharges(RichInputText bankCharges) {
        this.bankCharges = bankCharges;
    }

    public RichInputText getBankCharges() {
        return bankCharges;
    }
        

    public void setHandlingCharges(RichInputText handlingCharges) {
        this.handlingCharges = handlingCharges;
    }

    public RichInputText getHandlingCharges() {
        return handlingCharges;
    }

    public void setDiscount(RichInputText discount) {
        this.discount = discount;
    }

    public RichInputText getDiscount() {
        return discount;
    }

    public void setOther(RichInputText other) {
        this.other = other;
    }

    public RichInputText getOther() {
        return other;
    }

    public void setDocumentNumber(RichInputText documentNumber) {
        this.documentNumber = documentNumber;
    }

    public RichInputText getDocumentNumber() {
        return documentNumber;
    }

    public void AttachDocument(ActionEvent actionEvent) {
        // Add event code here...
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        String datetime = dateFormat.format(date);
        System.out.println(datetime);
        String newPage =
             "http://192.168.200.115:7003/FileUploading-ViewController-context-root/faces/view1?doc=PI&docNo="+getDocumentNumber().getValue()+"["+datetime+"]";
         // String newPage = "http://localhost:7101/PurchaseMemo-ViewController-context-root/faces/SearchPG?headerId="+getBomId().getValue();
         FacesContext ctx = FacesContext.getCurrentInstance();
         ExtendedRenderKitService erks =
             Service.getService(ctx.getRenderKit(), ExtendedRenderKitService.class);
         String url = "window.open('" + newPage + "','_self');";
         erks.addScript(FacesContext.getCurrentInstance(), url); 
    }
    
    /* PI No Validation */    



    public void pinovalidation(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        System.out.println(valueChangeEvent.getNewValue()); 
        oracle.binding.OperationBinding operationBinding= executeOperation("pinovalidation");
        //oracle.binding.OperationBinding operationBinding = executeOperation("populateBpoLines1");
        operationBinding.getParamsMap().put("bblcnumber", valueChangeEvent.getNewValue());
        operationBinding.execute();
        
        if (!operationBinding.getErrors().isEmpty()) {
                 System.out.println("if errors-->");
                 // List errors = operationBinding.getErrors();
             }
             //optional
             Object methodReturnValue = operationBinding.getResult();
             int value = Integer.parseInt(methodReturnValue.toString());
        //     return value;
             
             if (value == 1 )
             {
                 
                    /* Message Printing */
                    
                    FacesContext context = FacesContext.getCurrentInstance();          
                    FacesMessage message = new FacesMessage("Duplicate Record Found , Enter a Unique PI Number ");          
                    context.addMessage(null, message);
                    
                    
                    /* End Message */ 
                }
    }
     /* End PI Validation */
     public void setProposalDate(RichInputDate proposalDate) {
             this.proposalDate = proposalDate;
         }
        public RichInputDate getProposalDate() {
            return proposalDate;
        }

    public void ShowDateBind() {
        
        
         
                    String status =null;
                    String stmt = 
                        "BEGIN MNJ_PI_REC_DATE_UPD(:1); end;";
                    
                    
                    CallableStatement cs = appM.getDBTransaction().createCallableStatement(stmt, 1);
                    
                    try {
                        cs.setString(1,getImpLine_ID_Bind().getValue().toString());
                        cs.execute();
                        cs.close();
                    }
                    catch (Exception e)
                    {                        
                        status = e.getMessage();
                        try {
                            cs.close();
                        } catch (SQLException f) {
                            ;
                        }
                    } 
                  
               this.refreshQueryKeepingCurrentRow(appM.getImpPiLines1());
                  
                    
              //   appM.getImpPiLines1().executeQuery();  
                    
            AdfFacesContext.getCurrentInstance().addPartialTarget(proposalDate);            
                 
                 
    }

    public void setImpLine_ID_Bind(RichInputText impLine_ID_Bind) {
        this.impLine_ID_Bind = impLine_ID_Bind;
    }

    public RichInputText getImpLine_ID_Bind() {
        return impLine_ID_Bind;
    }

    public void setBblcNoAgainstPi(RichOutputText bblcNoAgainstPi) {
        this.bblcNoAgainstPi = bblcNoAgainstPi;
    }

    public RichOutputText getBblcNoAgainstPi() {
        return bblcNoAgainstPi;
    }

    public void setPiNo(RichInputText piNo) {
        this.piNo = piNo;
    }

    public RichInputText getPiNo() {
        return piNo;
    }

    public void searchBBLCforPI(ActionEvent actionEvent) {
        
        
         
        String query= "SELECT DISTINCT ibl.BBLC_NO  FROM IEDOC_IMP_BBLC_LINES ibl, IEDOC_IMP_BBLC_PI_DETAILS ibpd\n" + 
        "WHERE ibl.IMP_BBLC_LINE_ID = ibpd.IMP_BBLC_LINE_ID\n" + 
        "\n" + 
        "AND ibpd.PI_NO =?";
        
         ResultSet resultSet=null;            
         
         try{
             PreparedStatement createStatement= appM.getDBTransaction().createPreparedStatement(query, 1);

             createStatement.setString(1, getPiNo().getValue().toString());
//             System.out.println("====================== searching pi  "+ getPiNo().getValue().toString());
             resultSet = createStatement.executeQuery();
             String BBLCNo=null;
             if(resultSet.next()){
                 BBLCNo = resultSet.getString("BBLC_NO"); 
             }
             else{
                 BBLCNo = "No BBLC Found";
             }
             
              
             bblcNoAgainstPi.setValue(BBLCNo);
             resultSet.close();
             createStatement.close();
             
             
         }catch(Exception e){
           e.printStackTrace();
           
         }
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(bblcNoAgainstPi); 
       
      
      
    }

    public void OnPiQueryPGLoad() {
          Map sessionScope = ADFContext.getCurrent().getSessionScope();   
                String resp = (String)sessionScope.get("respId");
                // commertial ho responsibility = 51318
                if(resp=="51318"){
                    bbLCsearchForm.setVisible(true);
                }else{
                    bbLCsearchForm.setVisible(false);
                }
        AdfFacesContext.getCurrentInstance().addPartialTarget(bbLCsearchForm); 
               
                
                
    }

    public void setBbLCsearchForm(RichPanelFormLayout bbLCsearchForm) {
        this.bbLCsearchForm = bbLCsearchForm;
    }

    public RichPanelFormLayout getBbLCsearchForm() {
        return bbLCsearchForm;
    }
    
    
    public void setCurrentPiRow(ActionEvent actionEvent) {
        // Add event code here...
        
        ViewObject exVo = appM.getImpPiLinesVOEx1();
        ImpPiLinesVORowImpl currentRow = (ImpPiLinesVORowImpl)exVo.getCurrentRow();
       
        System.out.println("====================== currentRow.getPiNo()  "+currentRow.getPiNo());
        
        ViewObject lineVO =  appM.getImpPiLines1();
        lineVO.setWhereClause(null);       
        lineVO.executeQuery();
        setLineVoCurrentRow( currentRow);
        
    }
    
    
    public void refreshQueryKeepingCurrentRow(ViewObject viewObject )  {
        
        
         Row currentRow;
         Key currentRowKey;
         
         // added on 7.jan.18 to handle exception if view object has no current row
        try{
           currentRow = viewObject.getCurrentRow();
           currentRowKey = currentRow.getKey();
        }
        catch(Exception e){
            return;
        }
        
      
       int rangePosOfCurrentRow = viewObject.getRangeIndexOf(currentRow);
       int rangeStartBeforeQuery = viewObject.getRangeStart();
       viewObject.executeQuery();
       viewObject.setRangeStart(rangeStartBeforeQuery);
       /*
        * In 10.1.2, there is this convenience method we could use
        * instead of the remaining lines of code
        *
        *  findAndSetCurrentRowByKey(currentRowKey,rangePosOfCurrentRow);
        *  
        */
       
       Row[] rows = viewObject.findByKey(currentRowKey, 1);
        
        
        
      
       
       if (rows != null && rows.length == 1)
       {
          viewObject.scrollRangeTo(rows[0], rangePosOfCurrentRow);
          viewObject.setCurrentRowAtRangeIndex(viewObject.getRangeIndexOf(rows[0]));
       }
       
               
     }


    private void setLineVoCurrentRow(Row currentRow) {
        ViewObject lineVo  = appM.getImpPiLines1();
            
        Key currentRowKey ;
        currentRowKey = currentRow.getKey();
        
        int rangePosOfCurrentRow = lineVo.getRangeIndexOf(currentRow);
        
        if (rangePosOfCurrentRow<0) {
            rangePosOfCurrentRow=1;
        }
        
    //        System.out.println("-------------------------- rangePosOfCurrentRow  "+ rangePosOfCurrentRow);
        
        int rangeStartBeforeQuery = lineVo.getRangeStart();
        
    //        System.out.println("-------------------------- rangeStartBeforeQuery  "+ rangeStartBeforeQuery);
        
        lineVo.executeQuery();
        lineVo.setRangeStart(rangeStartBeforeQuery);
        /*
         * In 10.1.2, there is this convenience method we could use
         * instead of the remaining lines of code
         *
         *  findAndSetCurrentRowByKey(currentRowKey,rangePosOfCurrentRow);
         *  
         */
        
        Row[] rows = lineVo.findByKey(currentRowKey, 1);
        
        if (rows != null && rows.length == 1)
        {                                
           lineVo.scrollRangeTo(rows[0], rangePosOfCurrentRow);
           lineVo.setCurrentRowAtRangeIndex(lineVo.getRangeIndexOf(rows[0]));
        }
        
        
    }


    public void setFillBpoPopYpTable(RichTable fillBpoPopYpTable) {
        this.fillBpoPopYpTable = fillBpoPopYpTable;
    }

    public RichTable getFillBpoPopYpTable() {
        return fillBpoPopYpTable;
    }
}


