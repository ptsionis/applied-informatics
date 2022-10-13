<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="TestWebsite.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Καλημέρα</title>
    <style type="text/css">
        .auto-style1 {
            color: #FF0000;
            font-family: "Courier New", Courier, monospace;
        }
        .auto-style2 {
            width: 100%;
        }
        .auto-style3 {
            width: 612px;
            height: 354px;
        }
        .auto-style4 {
            width: 900px;
            height: 616px;
        }
        .auto-style5 {
            width: 728px;
            height: 485px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server" style="background-color: #00FFFF" title="SOS">
        <div>

            <h1 class="auto-style1">Ένα πρώτο δοκιμαστικό site</h1>

        </div>
        <table class="auto-style2">
            <tr>
                <td>
        <asp:Label ID="Label1" runat="server" Text="Random Label Name"></asp:Label>
                </td>
                <td>
                    <img alt="Athens" class="auto-style3" src="Photos/Athens.jpg" /></td>
            </tr>
            <tr>
                <td>
                    <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
                </td>
                <td>
                    <img alt="Thessaloniki" class="auto-style4" src="Photos/Thessaloniki.jpg" style="width: auto; height: auto; table-layout: auto" /></td>
            </tr>
            <tr>
                <td>
        <asp:Button ID="Button1" runat="server" Text="Click Me!" OnClick="Button1_Click" />
                </td>
                <td>
                    <img alt="Crete" class="auto-style5" src="Photos/Crete.jpg" style="width: auto; height: auto; table-layout: auto" /></td>
            </tr>
        </table>
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="Id" DataSourceID="SqlDataSource1">
            <Columns>
                <asp:BoundField DataField="Id" HeaderText="Id" ReadOnly="True" SortExpression="Id" />
                <asp:BoundField DataField="Name" HeaderText="Name" SortExpression="Name" />
            </Columns>
        </asp:GridView>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>" SelectCommand="SELECT [Id], [Name] FROM [Ypallilos]"></asp:SqlDataSource>
    </form>
</body>
</html>
