﻿using System;
using DevExpress.Xpo;
using DevExpress.Xpo.Metadata;
using DevExpress.Data.Filtering;
using System.Collections.Generic;
using System.ComponentModel;
using System.Reflection;
namespace CNPM_Community_support.Module.ORMDataModel1
{

    public partial class Bieumau
    {
        public Bieumau(Session session) : base(session) { }
        public override void AfterConstruction() { base.AfterConstruction(); }
    }

}
