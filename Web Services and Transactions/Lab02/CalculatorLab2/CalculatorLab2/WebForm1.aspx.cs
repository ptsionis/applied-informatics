using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CalculatorLab2
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        // δήλωση της μεταβλητής της υπηρεσίας
        com.dneonline.www.Calculator myWS = new com.dneonline.www.Calculator();

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void clearButton_Click(object sender, EventArgs e)
        {
            number1.Text = "";
            number2.Text = "";
        }

        protected void addButton_Click1(object sender, EventArgs e)
        {
            int a, b, res;

            a = Convert.ToInt32(number1.Text);
            b = Convert.ToInt32(number2.Text);

            res = myWS.Add(a, b);

            resultLabel.Text = Convert.ToString(res);
        }

        protected void mulButton_Click(object sender, EventArgs e)
        {
            int a, b, res;

            a = Convert.ToInt32(number1.Text);
            b = Convert.ToInt32(number2.Text);

            res = myWS.Multiply(a, b);

            resultLabel.Text = Convert.ToString(res);
        }

        protected void minusButton_Click(object sender, EventArgs e)
        {
            int a, b, res;

            a = Convert.ToInt32(number1.Text);
            b = Convert.ToInt32(number2.Text);

            res = myWS.Subtract(a, b);

            resultLabel.Text = Convert.ToString(res);
        }

        protected void divButton_Click(object sender, EventArgs e)
        {
            int a, b, res;

            a = Convert.ToInt32(number1.Text);
            b = Convert.ToInt32(number2.Text);

            if (b!=0)
            {
                res = myWS.Divide(a, b);
                resultLabel.Text = Convert.ToString(res);
            }
            else if (a!=0)
            {
                resultLabel.Text = "Αδύνατη πράξη";
            }
            else
            {
                resultLabel.Text = "Αοριστία";
            }
        }
    }
}