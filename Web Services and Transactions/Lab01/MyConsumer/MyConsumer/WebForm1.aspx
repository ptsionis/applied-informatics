<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="MyConsumer.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:TextBox ID="tbMyValue" runat="server"></asp:TextBox><asp:Label runat="server" Text="Τιμή"></asp:Label>
            <div>&nbsp;</div>
            <asp:TextBox ID="tbMyTotal" runat="server"></asp:TextBox><asp:Label ID="Label1" runat="server" Text="Σύνολο"></asp:Label>
            <div>&nbsp;</div>
            <div>&nbsp;</div>
            <asp:Button ID="btnCalculate" runat="server" Text="Υπολογισμός" OnClick="btnCalculate_Click" />
            <div>&nbsp;</div>
            <asp:Label ID="lblPercentage" runat="server"></asp:Label><asp:Label ID="lblPercentageLabel" runat="server" Text="= ποσοστό που υπολογίστηκε" Visible="False"></asp:Label>
            <div>&nbsp;</div>
            <div>&nbsp;</div>
            <asp:Label ID="lblServerTime" runat="server"></asp:Label><asp:Label ID="Label2" runat="server" Text="= η ώρα στον server"></asp:Label>
        </div>
    </form>
</body>
</html>
