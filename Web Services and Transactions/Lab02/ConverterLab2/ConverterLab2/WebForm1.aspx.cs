using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;

namespace ConverterLab2
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        lt.lb.www.ExchangeRates myWS2 = new lt.lb.www.ExchangeRates();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack == false)
            {
                //Receive the XML node - root <Currencies>
                XmlNode node = myWS2.getListOfCurrencies();

                //Make a list with all <item> nodes from the above node
                //<Currencies>
                //  <item>
                //      ....
                //  </item>
                //</Currencies>
                XmlNodeList nodes = node.SelectNodes("//item");

                //For each item node, insert in my drop-lists the values from each item XML node
                foreach (XmlNode nd in nodes)
                {
                    fromCurrList.Items.Add(nd["currency"].InnerText + " " + nd["description"].InnerText);
                    toCurrList.Items.Add(nd["currency"].InnerText + " " + nd["description"].InnerText);

                    fromCurrList.SelectedIndex = 26;
                    toCurrList.SelectedIndex = 87;
                }
            }
        }

        protected void convertCurr_Click(object sender, EventArgs e)
        {
            decimal f, rateFrom = 0, rateTo = 0;
            string curr1, curr2;

            //Get the symbol of the selected From & To currencies and save them as strings
            curr1 = Convert.ToString(fromCurrList.SelectedItem).Substring(0, 3);
            curr2 = Convert.ToString(toCurrList.SelectedItem).Substring(0, 3);

            //Receive the XML node - root <ExchangeRates> from 31st Dec 2014
            XmlNode node = myWS2.getExchangeRatesByDate("2014-12-31");

            //Make a list with all <item> nodes from the above node
            //<ExchangeRates>
            //  <item>
            //      ....
            //  </item>
            //<ExchangeRates>
            XmlNodeList nodes = node.SelectNodes("//item");

            foreach (XmlNode nd in nodes)
            {
                
                //1 From Currency / x LTL
                if (nd["currency"].InnerText == curr1)
                {
                    rateFrom = Convert.ToDecimal(nd["rate"].InnerText) / Convert.ToInt32(nd["quantity"].InnerText);
                }

                //1 To Currency / x LTL
                if (nd["currency"].InnerText == curr2)
                {
                    rateTo = Convert.ToDecimal(nd["rate"].InnerText) / Convert.ToInt32(nd["quantity"].InnerText);
                }
            }

            //From Currency / To Currency * amount
            f = Math.Round(Convert.ToDecimal(amountCurr.Text) * (rateFrom/rateTo), 2);
            resultCurr.Text = Convert.ToString(f);
        }
    }
}