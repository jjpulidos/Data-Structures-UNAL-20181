#include <bits/stdc++.h>

using namespace std;

typedef long long ll;


vector<ll> arr;

struct node
{
    int data;
    struct node *left, *right;
};
void preorder(struct node*root) {
    if (root != NULL) {
        arr.push_back(root->data);
        preorder(root->left);    //Go to left subtree
        preorder(root->right);     //Go to right subtree
    }
}
struct node *newNode(int item)
{
    struct node *temp =  (struct node *)malloc(sizeof(struct node));
    temp->data = item;
    temp->left = temp->right = NULL;
    return temp;
}


struct node* insert(struct node* root, int data)
{
    if (root == NULL)    //If the tree is empty, return a new,single node
        return newNode(data);
    else
    {
        //Otherwise, recur down the tree
        if (data <= root->data)
            root->left  = insert(root->left, data);
        else
            root->right = insert(root->right, data);
        //return the (unchanged) root pointer
        return root;
    }
}


int main()
{
   ll q;
    scanf("%lld", &q);
    struct node *root = NULL;
    ll n;
    scanf("%lld",&n);
    root = insert(root, n);
    q--;
    while(q--){
        ll temp;
        scanf("%lld",&temp);
        insert(root,temp);
    }
    preorder(root);
    ll m;
    scanf("%lld",&m);
    while(m--){
        ll temp;
        scanf("%lld",&temp);
        printf("%lld\n",arr[temp-1]);
    }
    return 0;
}
