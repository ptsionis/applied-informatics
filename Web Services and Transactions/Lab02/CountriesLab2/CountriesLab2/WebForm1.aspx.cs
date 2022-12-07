using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CountriesLab2
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        org.oorsprong.www.CountryInfoService ct = new org.oorsprong.www.CountryInfoService();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack == false)
            {
                countryList.Items.Add("-Select-");

                org.oorsprong.www.tCountryCodeAndName[] can = ct.ListOfCountryNamesByName();

                for (int i=0; i<can.Length; i++)
                {
                    countryList.Items.Add(can[i].sName);
                }
            }
        }

        protected void serviceButton_Click(object sender, EventArgs e)
        {
            string strIsoCountry = ct.CountryISOCode(countryList.Text);
            isoLabel.Text = strIsoCountry;

            string strCapital = ct.CapitalCity(strIsoCountry);
            capitalLabel.Text = strCapital;

            string strImageURL = ct.CountryFlag(strIsoCountry);
            flagImage.ImageUrl = strImageURL;

            string strPhone = ct.CountryIntPhoneCode(strIsoCountry);
            phoneLabel.Text = strPhone;

            org.oorsprong.www.tCurrency curr = ct.CountryCurrency(strIsoCountry);
            currLabel.Text = curr.sName + " (" + curr.sISOCode + ")";
        }
    }
}