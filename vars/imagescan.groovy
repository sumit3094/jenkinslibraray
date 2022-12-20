def call{

    sh """trivy image -f json -o results.json ${full_image_name}

            
    """
}