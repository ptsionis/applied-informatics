<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="CountriesLab2.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="Label1" runat="server" Text="ΠΛΗΡΟΦΟΡΙΕΣ ΧΩΡΑΣ" Font-Size="Larger" Font-Bold="True"></asp:Label><br /><br />
            <asp:Label ID="Label2" runat="server" Text="Χώρα:"></asp:Label>&nbsp;
            <asp:DropDownList ID="countryList" runat="server"></asp:DropDownList><br /><br />
            <asp:Label ID="Label3" runat="server" Text="Iso Code: "></asp:Label>&nbsp;
            <asp:Label ID="isoLabel" runat="server" Text=""></asp:Label><br /><br />
            <asp:Label ID="Label4" runat="server" Text="Πρωτεύουσα: "></asp:Label>&nbsp;
            <asp:Label ID="capitalLabel" runat="server" Text=""></asp:Label><br /><br />
            <asp:Image ID="flagImage" runat="server" /><br /><br />
            <asp:Label ID="Label5" runat="server" Text="Κωδικός Διεθνούς Κλήσης: "></asp:Label>&nbsp;
            <asp:Label ID="phoneLabel" runat="server" Text=""></asp:Label><br /><br />
            <asp:Label ID="Label6" runat="server" Text="Νόμισμα: "></asp:Label>&nbsp;
            <asp:Label ID="currLabel" runat="server" Text=""></asp:Label><br /><br />
            <asp:Button ID="serviceButton" runat="server" Text="Κλήση Υπηρεσίας" OnClick="serviceButton_Click" />
        </div>
    </form>
</body>
</html>
