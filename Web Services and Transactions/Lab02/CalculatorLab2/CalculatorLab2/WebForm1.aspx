<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="CalculatorLab2.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label runat="server" Text="Αριθμομηχανή" Font-Bold="True" Font-Size="Larger"></asp:Label>
        </div>
        <div>&nbsp;</div>
        <div>
            <asp:Label ID="num1Label" runat="server" Text="Αριθμός Α:"></asp:Label>
            <asp:TextBox ID="number1" runat="server"></asp:TextBox>
        </div>
        <div>&nbsp;</div>
        <div>
            <asp:Button ID="addButton" runat="server" Text="+" OnClick="addButton_Click1" />
            &nbsp;
            <asp:Button ID="mulButton" runat="server" Text="*" OnClick="mulButton_Click" />
            &nbsp;
            <asp:Button ID="minusButton" runat="server" Text="-" OnClick="minusButton_Click" />
            &nbsp;
            <asp:Button ID="divButton" runat="server" Text="/" OnClick="divButton_Click" />
            &nbsp;
            <asp:Button ID="clearButton" runat="server" Text="Καθαρισμός" OnClick="clearButton_Click" />
        </div>
        <div>&nbsp;</div>
        <div>
            <asp:Label ID="num2Label" runat="server" Text="Αριθμός Β:"></asp:Label>
            <asp:TextBox ID="number2" runat="server"></asp:TextBox>
        </div>
        <div>&nbsp;</div>
        <div>
            <asp:Label runat="server" Text="Αποτέλεσμα:" Font-Bold="True" Font-Size="Larger"></asp:Label>
            &nbsp;
            <asp:Label ID="resultLabel" runat="server"></asp:Label>
        </div>
    </form>
</body>
</html>
