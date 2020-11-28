fun main(){

    var productInfo : ArrayList<ProductInfo> = ArrayList()
    productInfo.add(ProductInfo(27,"https://aws-mhs-bucket.s3-ap-southeast-1.amazonaws.com/ITBaby/images/product/c65ffea5-e95f-47cd-ae24-1c31bc04b21f.jpg",1,"Cotton Baby bed sheet",12000,10800,"White",4,23))
    productInfo.add(ProductInfo(51,"https://aws-mhs-bucket.s3-ap-southeast-1.amazonaws.com/ITBaby/images/product/3d885d86-dd4a-4f30-b055-b6ce28eedec6.jpg",4,"Long pants",30000,29400,"M,Blue",10,0))
    productInfo.add(ProductInfo(222,"https://aws-mhs-bucket.s3-ap-southeast-1.amazonaws.com/ITBaby/images/product/df79f6f4-cc48-4a05-9ab2-dedaf03e1403.jpg",1,"Baby Unisex Trouser",16000,12800,"S,Red",1,1))
    productInfo.add(ProductInfo(222,"https://aws-mhs-bucket.s3-ap-southeast-1.amazonaws.com/ITBaby/images/product/df79f6f4-cc48-4a05-9ab2-dedaf03e1403.jpg",2,"Baby Unisex Trouser",16000,12800,"S,Blue",36,35))
    productInfo.add(ProductInfo(222,"https://aws-mhs-bucket.s3-ap-southeast-1.amazonaws.com/ITBaby/images/product/df79f6f4-cc48-4a05-9ab2-dedaf03e1403.jpg",3,"Baby Unisex Trouser",16000,12800,"S,Silver",40,40))
    productInfo.add(ProductInfo(243,"https://aws-mhs-bucket.s3-ap-southeast-1.amazonaws.com/ITBaby/images/product/80a3cbd4-23e8-4676-ad71-1e0f30ebe7ca.jpg",4,"Strawberry Yogurt",400,380,"Berry,100ml",20,20))
    productInfo.add(ProductInfo(243,"https://aws-mhs-bucket.s3-ap-southeast-1.amazonaws.com/ITBaby/images/product/80a3cbd4-23e8-4676-ad71-1e0f30ebe7ca.jpg",7,"Strawberry Yogurt",400,380,"Orange,100ml",28,25))
    productInfo.add(ProductInfo(243,"https://aws-mhs-bucket.s3-ap-southeast-1.amazonaws.com/ITBaby/images/product/80a3cbd4-23e8-4676-ad71-1e0f30ebe7ca.jpg",10,"Strawberry Yogurt",400,380,"Delight,100ml",66,9998))
    productInfo.add(ProductInfo(255,"https://aws-mhs-bucket.s3-ap-southeast-1.amazonaws.com/ITBaby/images/product/f06c927f-b55f-490d-a609-f92e1627bc6a.jpg",1,"Mouse Pad",5000,0,"Normal,Pink",3,3))


    var productIssues :ArrayList<ProductIssues> = ArrayList()
    productIssues.add(ProductIssues(51,4,"Long pants","OutOfStock",0,"You'er order 10 quantities of Long pants, but we only have 0 quantity left."))
    productIssues.add(ProductIssues(222,2,"Baby Unisex Trouser","OutOfStock",35,"You'er order 36 quantities of Baby Unisex Trouser, but we only have 35 quantities left."))
    productIssues.add(ProductIssues(243,7,"Strawberry Yogurt","OutOfStock",25,"You'er order 28 quantities of Strawberry Yogurt, but we only have 25 quantities left."))
    productIssues.add(ProductIssues(255,1,"Mouse Pad","Delete",3,"Your order item - Mouse Pad has been deleted by seller."))


//    productIssues.add(ProductIssues(500,1,"Mouse Pad","Delete",3,"Your order item - Mouse Pad has been deleted by seller."))
    var list1 : ArrayList<ResultModel> = ArrayList()
    var list2 : ArrayList<ResultModel> = ArrayList()


    for (productInfoData in productInfo){
        for (productIssuesData in productIssues){
            if (productInfoData.id == productIssuesData.productId && productInfoData.sku == productIssuesData.skuId){
                list1.add(ResultModel(productInfoData.id,productInfoData.productUrl,productInfoData.sku,productInfoData.name,productInfoData.price,productInfoData.promotePrice,productInfoData.variation,productInfoData.qty,productInfoData.availableQty))
            }
        }
    }

    for (productInfoData in productInfo) {
        for (list1Data in list1){
            if (!(list1.contains(ResultModel(productInfoData.id,productInfoData.productUrl,productInfoData.sku,productInfoData.name,productInfoData.price,productInfoData.promotePrice,productInfoData.variation,productInfoData.qty,productInfoData.availableQty)))){
                if (!list2.contains(ResultModel(productInfoData.id,productInfoData.productUrl,productInfoData.sku,productInfoData.name,productInfoData.price,productInfoData.promotePrice,productInfoData.variation,productInfoData.qty,productInfoData.availableQty))){
                    list2.add(ResultModel(productInfoData.id,productInfoData.productUrl,productInfoData.sku,productInfoData.name,productInfoData.price,productInfoData.promotePrice,productInfoData.variation,productInfoData.qty,productInfoData.availableQty))
                }
            }
        }
    }


    println("List_1")
    for (data in list1){
        println("ProductId = ${data.productId}, SkuID = ${data.skuId}, Name = ${data.name}, Price = ${data.price}, variation = ${data.variation}, Qty = ${data.qty}, AvailableQty = ${data.availableQty}")
    }

    print("\n")

    println("List_2")
    for (data in list2){
        println("ProductId = ${data.productId}, SkuID = ${data.skuId}, Name = ${data.name}, Price = ${data.price}, variation = ${data.variation}, Qty = ${data.qty}, AvailableQty = ${data.availableQty}")
    }

}