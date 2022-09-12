# Analysis of Credit Risk Classification Machine Learning Models
## Overview of the Analysis
### Purpose of the Analysis
Credit risk poses a classification problem that’s inherently imbalanced. This is because healthy loans easily outnumber risky loans. The analysis implements various techniques to train and evaluate models with imbalanced classes. It uses a dataset of historical lending activity from a peer-to-peer lending services company to build a model that can identify the creditworthiness of borrowers.
### Financial information used
The dataset is a csv file comprised of financial data derived from a lending services company. The data comprises: loan size, interest rate, borrower income, debt-to-income, number of accounts, derogatory marks, total debt and loan status for each data point.
The loan status column serves as the labels for the model while the rest of the columns in the dataset serve as the features used in prediction. A value of `0` in the loan status column means that the loan is healthy. A value of `1` means that the loan has a high risk of defaulting. 
### Stages of the machine learning process
1.	Splitting the Data into Training and Testing Sets.<br />
  Process:<br />
a) Loading the `lending_data.csv` data from the `Resources` folder into a Pandas Data Frame. \
b) Creating the labels set (`y`) from the loan status column, and then create the features (`X`) Data Frame from the remaining columns. \
c) Check the balance of the label’s variable (`y`).

2. Split the data into training and testing datasets.\
Process:<br />
a)	Creating a Logistic Regression Model with the Original Data \
b) Fitting a logistic regression model by using the training data (`X_train` and `y_train`). \
c) Saving the predictions on the testing data labels by using the testing feature data (`X_test`) and the fitted model. \
d) Evaluating the model’s performance by calculating the accuracy score of the model, generating a confusion matrix and printing the classification report. \

3. Predicting a Logistic Regression Model with Resampled Training Data.\
Process:<br />
a) Using the `RandomOverSampler` module to resample the data. \
b) Using the `LogisticRegression` classifier and the resampled data to fit the model and make predictions.\
c) Evaluating the model’s performance by calculating the accuracy score of the model, generating a confusion matrix and printing the classification report.

### Methods used
Logistic regression Model
a statistical method that is used for building machine learning models where the dependent variable is dichotomous: i.e., binary. Logistic regression is used to describe data and the relationship between one dependent variable and one or more independent variables. The independent variables can be nominal, ordinal, or of interval type.

Logistic Regression Model with Resampled Training Data \
in order to estimate the variability of a linear regression fit, different samples are repeatedly drawn from the training data, each new sample is fitted to a linear regression, and then examine the extent to which the resulting fits differ is then examined.
## Results
Machine Learning model 1
Accuracy
The balanced accuracy score of the first model as computed is 0.9520479254722232.
Precision
Out of all the values that the model predicted were healthy loans, 100% were. 85% of the values were accurately predicted to be high-risk loans.
Recall
Out of all the values that were high-risk loans, the model predicted this outcome correctly for 91% of those values.
Out of all the values that were healthy loans, the model predicted this outcome correctly for 99% of those values.
Machine Learning model 2
Accuracy
The computed balanced accuracy score of the second model is 0.9936781215845847.
Precision
Out of all the values that the model predicted were healthy loans, 100% were. 84% of the values were accurately predicted to be high-risk loans.
Recall
Out of all the values that were high-risk loans, the model predicted this outcome correctly for 99% of those values.
Out of all the values that were healthy loans, the model predicted this outcome correctly for 99% of those values.
## Summary
Examination of the results of the analysis reveals that the machine learning model 2 with used resampled data is more accurate in predicting the output values. It has higher balanced accuracy score and recall scores.
The performance depends on the problem being solved. It is more important to predict the `0`’s than the `1`’s. Prediction of high-risk values reduces the precision of the two machine learning models.
