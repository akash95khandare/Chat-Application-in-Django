from OOPS.StockAccount import FileLoad


class Customer:
    def __init__(self):
        self.company_data = FileLoad.json_file_load("Company.json")
        self.customer_data = FileLoad.json_file_load("Customer.json")
        self.cus_index = 0

    def buy(self, customer_id, company_name, customer_name, no_of_share):
        cus_index = 0
        flag = True
        for i in range(len(self.customer_data)):
            if int(self.customer_data[i]["id"]) == customer_id and self.customer_data[i]["name"] == customer_name:
                cus_index = i
                flag = False
                self.cus_index = i
        if flag:
            print("Customer data not found.")
            return

        com_index = 0
        flag = True
        for i in range(len(self.company_data)):
            print(self.company_data[i]["name"], company_name)
            if company_name == self.company_data[i]["name"]:
                com_index = i
                flag = False
                break
        if flag:
            print("Company data not found.")
            return
        print("comapany data :", self.company_data[com_index])

        total_amount = no_of_share * int(self.company_data[com_index]["data"]["price"])

        if int(self.customer_data[cus_index].get("balance")) >= total_amount and int(
                self.company_data[com_index]["data"].get("no_of_share")) >= no_of_share:
            self.customer_data[cus_index]["balance"] = str(
                int(self.customer_data[cus_index].get("balance")) - total_amount)
            try:
                self.customer_data[cus_index]["data"][company_name] = str(
                    int(self.customer_data[cus_index]["data"].get(company_name)) + no_of_share)
            except Exception:
                self.customer_data[cus_index]["data"][company_name] = no_of_share
            # print(self.company_data[company_name].get("no_of_share"))
            self.company_data[com_index]["data"]["no_of_share"] = str(
                int(self.company_data[com_index]["data"].get("no_of_share")) - no_of_share)
            self.company_data[com_index]["data"]["balance"] = str(
                int(self.company_data[com_index]["data"]["balance"]) + total_amount)
        else:
            print("company or customer don't have enough share and money.")

    def sell(self, customer_id, company_name, customer_name, no_of_share):
        cus_index = 0
        flag = True
        for i in range(len(self.customer_data)):
            if int(self.customer_data[i]["id"]) == customer_id and self.customer_data[i]["name"] == customer_name:
                cus_index = i
                flag = False
                self.cus_index = i
        if flag:
            print("Customer data not found.")
            return
        flag = True
        com_index = 0
        for i in range(len(self.company_data)):
            if company_name == self.company_data[i]["name"]:
                com_index = i
                flag = False
        if flag:
            print("Company data not found.")
            return

        total_amount = no_of_share * int(self.company_data[com_index]["data"]["price"])

        if int(self.company_data[com_index]["data"].get("balance")) >= total_amount and int(
                self.customer_data[cus_index]["data"].get(company_name)) >= no_of_share:
            self.customer_data[cus_index]["balance"] = str(
                int(self.customer_data[cus_index].get("balance")) + total_amount)
            self.customer_data[cus_index]["data"][company_name] = str(
                int(self.customer_data[cus_index]["data"].get(company_name)) - no_of_share)
            # print(self.company_data[company_name].get("no_of_share"))
            self.company_data[com_index]["data"]["no_of_share"] = str(
                int(self.company_data[com_index]["data"].get("no_of_share")) + no_of_share)
            self.company_data[com_index]["data"]["balance"] = str(
                int(self.company_data[com_index]["data"]["balance"]) - total_amount)
        else:
            print("company or customer don't have enough share and money.")

    def save(self):
        if self.company_data == None or self.customer_data == None:
            print("Data is not read")
            return
        FileLoad.json_file_write("Customer.json", self.customer_data)
        FileLoad.json_file_write("Company.json", self.company_data)
        Customer()

    def print_report(self):
        print(self.customer_data[self.cus_index])


if __name__ == "__main__":
    pass
    # obj = Customer()
    # obj.buy(1234, "Google", "Akash", 10)
    # # obj.sell(1234, "Google", "Akash", 10)
    # obj.save()