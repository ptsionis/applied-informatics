﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// 
// This source code was auto-generated by Microsoft.VSDesigner, Version 4.0.30319.42000.
// 
#pragma warning disable 1591

namespace MyConsumer.localhost {
    using System.Diagnostics;
    using System;
    using System.Xml.Serialization;
    using System.ComponentModel;
    using System.Web.Services.Protocols;
    using System.Web.Services;
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.4084.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Web.Services.WebServiceBindingAttribute(Name="MyWServiceSoap", Namespace="http://mywebservice.org/")]
    public partial class MyWService : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback ServerTimeOperationCompleted;
        
        private System.Threading.SendOrPostCallback CalculatePercentageOperationCompleted;
        
        private bool useDefaultCredentialsSetExplicitly;
        
        /// <remarks/>
        public MyWService() {
            this.Url = global::MyConsumer.Properties.Settings.Default.MyConsumer_localhost_MyWService;
            if ((this.IsLocalFileSystemWebService(this.Url) == true)) {
                this.UseDefaultCredentials = true;
                this.useDefaultCredentialsSetExplicitly = false;
            }
            else {
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        public new string Url {
            get {
                return base.Url;
            }
            set {
                if ((((this.IsLocalFileSystemWebService(base.Url) == true) 
                            && (this.useDefaultCredentialsSetExplicitly == false)) 
                            && (this.IsLocalFileSystemWebService(value) == false))) {
                    base.UseDefaultCredentials = false;
                }
                base.Url = value;
            }
        }
        
        public new bool UseDefaultCredentials {
            get {
                return base.UseDefaultCredentials;
            }
            set {
                base.UseDefaultCredentials = value;
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        /// <remarks/>
        public event ServerTimeCompletedEventHandler ServerTimeCompleted;
        
        /// <remarks/>
        public event CalculatePercentageCompletedEventHandler CalculatePercentageCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://mywebservice.org/ServerTime", RequestNamespace="http://mywebservice.org/", ResponseNamespace="http://mywebservice.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public string ServerTime() {
            object[] results = this.Invoke("ServerTime", new object[0]);
            return ((string)(results[0]));
        }
        
        /// <remarks/>
        public void ServerTimeAsync() {
            this.ServerTimeAsync(null);
        }
        
        /// <remarks/>
        public void ServerTimeAsync(object userState) {
            if ((this.ServerTimeOperationCompleted == null)) {
                this.ServerTimeOperationCompleted = new System.Threading.SendOrPostCallback(this.OnServerTimeOperationCompleted);
            }
            this.InvokeAsync("ServerTime", new object[0], this.ServerTimeOperationCompleted, userState);
        }
        
        private void OnServerTimeOperationCompleted(object arg) {
            if ((this.ServerTimeCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.ServerTimeCompleted(this, new ServerTimeCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://mywebservice.org/CalculatePercentage", RequestNamespace="http://mywebservice.org/", ResponseNamespace="http://mywebservice.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public int CalculatePercentage(int myTotal, int myValue) {
            object[] results = this.Invoke("CalculatePercentage", new object[] {
                        myTotal,
                        myValue});
            return ((int)(results[0]));
        }
        
        /// <remarks/>
        public void CalculatePercentageAsync(int myTotal, int myValue) {
            this.CalculatePercentageAsync(myTotal, myValue, null);
        }
        
        /// <remarks/>
        public void CalculatePercentageAsync(int myTotal, int myValue, object userState) {
            if ((this.CalculatePercentageOperationCompleted == null)) {
                this.CalculatePercentageOperationCompleted = new System.Threading.SendOrPostCallback(this.OnCalculatePercentageOperationCompleted);
            }
            this.InvokeAsync("CalculatePercentage", new object[] {
                        myTotal,
                        myValue}, this.CalculatePercentageOperationCompleted, userState);
        }
        
        private void OnCalculatePercentageOperationCompleted(object arg) {
            if ((this.CalculatePercentageCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.CalculatePercentageCompleted(this, new CalculatePercentageCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        public new void CancelAsync(object userState) {
            base.CancelAsync(userState);
        }
        
        private bool IsLocalFileSystemWebService(string url) {
            if (((url == null) 
                        || (url == string.Empty))) {
                return false;
            }
            System.Uri wsUri = new System.Uri(url);
            if (((wsUri.Port >= 1024) 
                        && (string.Compare(wsUri.Host, "localHost", System.StringComparison.OrdinalIgnoreCase) == 0))) {
                return true;
            }
            return false;
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.4084.0")]
    public delegate void ServerTimeCompletedEventHandler(object sender, ServerTimeCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.4084.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class ServerTimeCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal ServerTimeCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public string Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((string)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.4084.0")]
    public delegate void CalculatePercentageCompletedEventHandler(object sender, CalculatePercentageCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.8.4084.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class CalculatePercentageCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal CalculatePercentageCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public int Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((int)(this.results[0]));
            }
        }
    }
}

#pragma warning restore 1591