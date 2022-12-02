<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ConverterLab2.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="Label1" runat="server" Text="Μετατροπή Συναλλάγματος" Font-Bold="True" Font-Size="Larger"></asp:Label><br /><br />
            <asp:Label ID="Label2" runat="server" Text="Δώστε νόμισμα προέλευσης: "></asp:Label>&nbsp;
            <asp:TextBox ID="amountCurr" runat="server"></asp:TextBox>&nbsp;
            <asp:DropDownList ID="fromCurrList" runat="server" AutoPostBack="True"></asp:DropDownList><br /><br />
            <asp:Label ID="Label3" runat="server" Text="Δώστε νόμισμα προορισμού: "></asp:Label>&nbsp;
            <asp:DropDownList ID="toCurrList" runat="server" AutoPostBack="True"></asp:DropDownList><br /><br />
            <asp:Button ID="convertCurr" runat="server" Text="Μετατροπή" OnClick="convertCurr_Click" /><br /><br />
            <asp:Label ID="resultCurr" runat="server" Text=""></asp:Label>
        </div>
    </form>
</body>
</html>
